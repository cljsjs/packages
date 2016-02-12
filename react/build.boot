(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.3")
(def +version+ (str +lib-version+ "-0"))

(def urls
  {:normal {:dev (str "http://fb.me/react-" +lib-version+ ".js")
            :dev-checksum "9927B8234985DB453299EB5A4591DD33"
            :min (str "http://fb.me/react-" +lib-version+ ".min.js")
            :min-checksum "C3207F7BF39699D4279BA404EA55F163"}
   :with-addons {:dev (str "http://fb.me/react-with-addons-" +lib-version+ ".js")
                 :dev-checksum "CFF72F35360E3433F6805F8C4F3305B3"
                 :min (str "http://fb.me/react-with-addons-" +lib-version+ ".min.js")
                 :min-checksum "CE4377AE601A9EC6A0870C5C9EF4B7BF"}})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (-> urls :normal :dev) :checksum (-> urls :normal :dev-checksum))
    (download :url (-> urls :normal :min) :checksum (-> urls :normal :min-checksum))
    (sift :move {(re-pattern (str "^react-" +lib-version+ ".js$"))     "cljsjs/react/development/react.inc.js"
                 (re-pattern (str "^react-" +lib-version+ ".min.js$")) "cljsjs/react/production/react.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react")))

(deftask package-with-addons []
  (task-options! pom {:project 'cljsjs/react-with-addons}
                 push {:ensure-branch nil :tag false})
  (comp
    (download :url (-> urls :with-addons :dev) :checksum (-> urls :with-addons :dev-checksum))
    (download :url (-> urls :with-addons :min) :checksum (-> urls :with-addons :min-checksum))
    (sift :move {(re-pattern (str "^react-with-addons-" +lib-version+ ".js$"))     "cljsjs/react/development/react-with-addons.inc.js"
                 (re-pattern (str "^react-with-addons-" +lib-version+ ".min.js$")) "cljsjs/react/production/react-with-addons.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react")))
