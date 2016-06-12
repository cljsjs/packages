(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/bcrypt
      :version     +version+
      :description "Optimized bcrypt in JavaScript with zero dependencies"
      :url         "https://github.com/dcodeIO/bcrypt.js"
      :scm         {:url "https://github.com/dcodeIO/bcrypt.js"}
      :license     {"New-BSD / MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
     (download :url (str "https://github.com/dcodeIO/bcrypt.js/archive/" +lib-version+ ".zip")
               :checksum "5e7a43fa75522dcd27ef28cf3923329b"
               :unzip true)

     (sift :move {#"^bcrypt.js-(.*)/dist/bcrypt.js$" "cljsjs/bcrypt/development/bcrypt.inc.js"
                  #"^bcrypt.js-(.*)/dist/bcrypt.min.js$" "cljsjs/bcrypt/production/bcrypt.min.inc.js"})

     (sift :include #{#"^cljsjs"})

     (deps-cljs :name "cljsjs.bcrypt")

     (pom)

     (jar)))
