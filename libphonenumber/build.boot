(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/libphonenumber
       :version     +version+
       :description "Google's JavaScript library for parsing, formatting, and validating international phone numbers."
       :url         "https://github.com/googlei18n/libphonenumber"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/googlei18n/libphonenumber/archive/libphonenumber-%s.zip" +lib-version+)
              :checksum "58FEFB66351AB6EB4AC749E80879CD49"
              :unzip true)
    (show :fileset true)
    (sift :move {#"^libphonenumber-libphonenumber-[\d\.]*/javascript/i18n/phonenumbers/" "cljsjs/libphonenumber/development/i18n/"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})
    (pom)
    (jar)))
