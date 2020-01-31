(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/jquery "2.2.4-0"]
                  ;; exclude jquery from bootstrap dep b/c notify can use
                  ;; jquery 2+
                  [cljsjs/bootstrap "3.3.6-1" :exclusions [cljsjs/jquery]]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/bootstrap-notify
        :version     +version+
        :description "This is a simple plugin that turns standard Bootstrap alerts into \"Growl-like\" notifications.\n\n"
        :url         "https://github.com/mouse0270/bootstrap-notify"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
           (download
             :url (str "https://github.com/mouse0270/bootstrap-notify/archive/" +lib-version+ ".zip")
             :checksum "93623E5DB0EB7A142A9A21BF7284E3EC"
             :unzip true)
           (sift :move {#"^bootstrap-notify-.*/dist/bootstrap-notify.js"
                        "cljsjs/bootstrap-notify/development/bootstrap-notify.inc.js"

                        #"^bootstrap-notify-.*/dist/bootstrap-notify.min.js"
                        "cljsjs/bootstrap-notify/production/bootstrap-notify.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.bootstrap-notify"
                      :requires ["cljsjs.jquery"
                                 "cljsjs.bootstrap"])
           (pom)
           (jar)))
