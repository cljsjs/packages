(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def react-version "0.13.1")
(def +version+ (str react-version "-0"))
(bootlaces! +version+)

(def urls
  {:normal {:dev (str "http://fb.me/react-" react-version ".js")
            :dev-checksum "E195BE5D021CBA5062E3C0F4C95DA322"
            :min (str "http://fb.me/react-" react-version ".min.js")
            :min-checksum "26B22E016CBE907215A04DBF03707622"}
   :with-addons {:dev (str "http://fb.me/react-with-addons-" react-version ".js")
                 :dev-checksum "F05CBC8CE979D2269947568789ECFDAA"
                 :min (str "http://fb.me/react-with-addons-" react-version ".min.js")
                 :min-checksum "C34D06B5F7840431BCAD2D3130978845"}})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (-> urls :normal :dev) :checksum (-> urls :normal :dev-checksum))
    (download :url (-> urls :normal :min) :checksum (-> urls :normal :min-checksum))
    (sift :move {(re-pattern (str "^react-" react-version ".js$"))     "cljsjs/development/react.inc.js"
                 (re-pattern (str "^react-" react-version ".min.js$")) "cljsjs/production/react.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react")))

(deftask package-with-addons []
  (task-options! pom {:project 'cljsjs/react-with-addons
                      :description "React.js with addons packaged up with Google Closure externs"}
                 push {:ensure-branch nil})
  (comp
    (download :url (-> urls :with-addons :dev) :checksum (-> urls :with-addons :dev-checksum))
    (download :url (-> urls :with-addons :min) :checksum (-> urls :with-addons :min-checksum))
    (sift :move {(re-pattern (str "^react-with-addons-" react-version ".js$"))     "cljsjs/development/react-with-addons.inc.js"
                 (re-pattern (str "^react-with-addons-" react-version ".min.js$")) "cljsjs/production/react-with-addons.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react")))
