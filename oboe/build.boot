(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-1"))

(defn url [ext]
 (str "https://raw.githubusercontent.com/jimhigson/oboe.js/v"
      +lib-version+
      "/dist/oboe-browser"
      ext))

(def urls
  {:normal {:dev (url ".js")
            :dev-checksum "43F549CD085EE2E6F040F11604FF48E5"
            :min (url ".min.js")
            :min-checksum "89295E1ED5BCCF151D4E881DF2896D05"}})

(task-options!
 pom  {:project     'cljsjs/oboe
       :version     +version+
       :description "A streaming approach to JSON. Oboe.js speeds up web applications by providing parsed objects before the response completes."
       :url         "http://oboejs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url (-> urls :normal :dev)
              :checksum (-> urls :normal :dev-checksum))
    (download :url (-> urls :normal :min)
              :checksum (-> urls :normal :min-checksum))
    (sift :move {#"^oboe-browser.js"     "cljsjs/oboe/development/oboe.inc.js"
                 #"^oboe-browser.min.js" "cljsjs/oboe/production/oboe.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.oboe")
    (pom)
    (jar)))

