(set-env!
  :source-paths #{"js"}
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [boot/core                 "2.0.0-pre28" :scope "provided"]
                  [adzerk/bootlaces          "0.1.5" :scope "test"]
                  [cljsjs/boot-cljsjs        "0.2.1"]])

(require
 '[boot.core          :as  c]
 '[adzerk.bootlaces   :refer :all]
 '[cljsjs.packaging   :as js])

(def project 'cljsjs/hammer)

(c/task-options!
  pom  {:project     project
        :description "Hammer.js packaged up with Google Closure externs"
        :url         "https://github.com/cljsjs/packages/tree/master/hammer"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}}
  js/cljsjs-jar {:project project})

(def variants
  {"2.0.4" {:none [:inc-js ["hammer-2.0.4.js"]
                   :ext-js ["hammer-externs.js"]]
            :min  [:inc-js ["hammer-2.0.4.min.js"]
                   :ext-js ["hammer-externs.js"]]}})

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
