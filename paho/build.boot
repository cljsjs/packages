(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/paho
       :version     +version+
       :description "A JavaScript MQTT client"
       :url         "http://eclipse.org/paho/"
       :scm         {:url "http://git.eclipse.org/c/paho/org.eclipse.paho.mqtt.javascript.git/"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
    (download :url "http://download.eclipse.org/paho/1.0/paho.javascript-1.0.1.zip"
              :checksum "1c7ebd961a5d6ed07925fce17f1e9fa7"
              :unzip true)
    ;; NB!!!
    ;; Please note that the minified version of the Paho javascript client
    ;; doesn't play ball with the Google Closure compiler for some reason
    (sift :move {#"^paho.javascript-\d.\d.\d/mqttws31.js$"     "cljsjs/paho/development/mqttws31.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.paho")
    (pom)
    (jar)))
