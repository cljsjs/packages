(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/jquery    "1.12.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/jquery-dropotron
        :version     +version+
        :description "A jQuery plugin that allows user to select a date range."
        :url         "https://github.com/ajlkn/jquery.dropotron"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/ajlkn/jquery.dropotron/archive/v%s.zip" +lib-version+)
             :checksum "D5708B6B71966C0219A2606395D12BBE"
             :unzip true)
   (sift :move {#"^jquery.dropotron-[^\/]*/jquery\.dropotron\.js"     "cljsjs/common/jquery-dropotron.inc.js"
                #"^jquery.dropotron-[^\/]*/jquery\.dropotron\.min.js" "cljsjs/common/jquery-dropotron.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jquery-dropotron"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
