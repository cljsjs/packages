(set-env!
  :source-paths #{"js"}
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [cljsjs/boot-cljsjs        "0.1.0"]
                  [boot/core                 "2.0.0-pre28" :scope "provided"]
                  [adzerk/bootlaces          "0.1.5" :scope "test"]])

(require
 '[boot.core          :as  c]
 '[boot.util          :as  util]
 '[boot.task.built-in :as task]
 '[clojure.java.io    :as io]
 '[adzerk.bootlaces   :refer :all]
 '[cljsjs.packaging   :as js])

(def project 'cljsjs/react)

(c/task-options!
  pom  {:project     project
        :description "React.js packaged up with Google Closure externs"
        :url         "https://github.com/cljsjs/reactjs"
        :scm         {:url "https://github.com/cljsjs/react"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}}
  js/cljsjs-jar {:project project})

(def variants
  {"0.11.2" {:none       [:inc-js ["react-0.11.2.js"]
                          :ext-js ["react-externs.js"]]
             :min        [:inc-js ["react-0.11.2.min.js"]
                          :ext-js ["react-externs.js"]]
             :addons     [:inc-js ["react-with-addons-0.11.2.js"]
                          :ext-js ["react-externs.js"]]
             :addons-min [:inc-js ["react-with-addons-0.11.2.min.js"]
                          :ext-js ["react-externs.js"]]}})

(c/deftask package ""
  [v version VERSION str "The version to package"
   t variant VARIANT kw  "The variant to package"]
  (bootlaces! version)
  (if (= variant nil)
    (apply js/cljsjs-jar (concat [:version version]
                                 (get-in variants [version :none])))

    (apply js/cljsjs-jar (concat [:classifier (name variant)
                                  :version version]
                                 (get-in variants [version variant])))))
