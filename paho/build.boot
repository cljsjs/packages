(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.3")
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
    (download :url "http://download.eclipse.org/paho/releases/1.0.3/paho.javascript-1.0.3.zip"
              :checksum "BC22B40826D77FF9BDDB9D0C10F8BDCD"
              :unzip true)
    (sift :move {#"^paho.javascript-\d+.\d+.\d+/paho-mqtt.js$"     "cljsjs/paho/development/paho-mqtt.inc.js" })
    (sift :move {#"^paho.javascript-\d+.\d+.\d+/paho-mqtt-min.js$"     "cljsjs/paho/production/paho-mqtt.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.paho")
    (pom)
    (jar)))
