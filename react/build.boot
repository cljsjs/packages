(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def react-version "0.13.0-rc2")
(def +version+ (str react-version "-0"))
(bootlaces! +version+)

(def urls
  {:normal {:dev (str "http://fb.me/react-" react-version ".js")
            :dev-checksum "C2BA8FB02812FC484CFCEC9A5A0A2459"
            :min (str "http://fb.me/react-" react-version ".min.js")
            :min-checksum "4D67F5CEF570C3E37B82100669595227"}
   :with-addons {:dev (str "http://fb.me/react-with-addons-" react-version ".js")
                 :dev-checksum "49EC8154989238B567CF32B99B7CB494"
                 :min (str "http://fb.me/react-with-addons-" react-version ".min.js")
                 :min-checksum "3F38EE6D0BAD46BD68F998CD45CAC2E6"}})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "React.js packaged up with Google Closure externs"
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
