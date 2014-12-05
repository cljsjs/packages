(set-env!
  :source-paths #{"js"}
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [cljsjs/boot-cljsjs        "0.1.0"]
                  [boot/core                 "2.0.0-pre27" :scope "provided"]
                  [tailrecursion/boot-useful "0.1.3"       :scope "test"]])

(require ;'[tailrecursion.boot-useful :refer :all]
 '[boot.core          :as  c]
 '[boot.util          :as  util]
 '[boot.task.built-in :as task]
 '[clojure.java.io    :as io]
 '[cljsjs.tasks       :as js])

(def +version+ "0.11.2")

;; (useful! +version+)

(task-options!
  pom  [:project     'cljsjs/react
        :version     +version+
        :description "React.js packaged up with Google Closure externs"
        :url         "https://github.com/cljsjs/reactjs"
        :scm         {:url "https://github.com/cljsjs/react"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}])

(c/task-options! js/cljsjs-jar [:project 'cljsjs/react
                                :version "0.11.2"])

(def variants
  {:none       [:inc-js ["react-0.11.2.js"]
                :ext-js ["react-externs.js"]]
   :min        [:inc-js ["react-0.11.2.min.js"]
                :ext-js ["react-externs.js"]]
   :addons     [:inc-js ["react-with-addons-0.11.2.js"]
                :ext-js ["react-externs.js"]]
   :addons-min [:inc-js ["react-with-addons-0.11.2.min.js"]
                :ext-js ["react-externs.js"]]})

(c/deftask package ""
  [v variant V kw "the variant to package"]
  (if (= variant :none)
    (apply js/cljsjs-jar (variant variants))
    (apply js/cljsjs-jar (concat [:classifier (name variant)]
                                 (variant variants)))))
