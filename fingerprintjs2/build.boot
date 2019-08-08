(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/fingerprintjs2
      :version     +version+
      :description "Modern & flexible browser fingerprinting library, a successor to the original fingerprintjs"
      :url         "http://valve.github.io/fingerprintjs2/"
      :scm         {:url "https://github.com/Valve/fingerprintjs2"}
      :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
   (download  :url      (str "https://raw.githubusercontent.com/Valve/fingerprintjs2/" +lib-version+ "/fingerprint2.js")
              :checksum "9107BD7E0DE1BCE64E191CEAC462848D")
   (download  :url      (str "https://raw.githubusercontent.com/Valve/fingerprintjs2/" +lib-version+ "/dist/fingerprint2.min.js")
              :checksum "D36240C5EBA9A5050C4A309F8721092E")
   (sift      :move     {#"^fingerprint2.js"
                         "cljsjs/fingerprintjs2/development/fingerprint2.inc.js"
                         #"^fingerprint2.min.js"
                         "cljsjs/fingerprintjs2/production/fingerprint2.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.fingerprintjs2")
   (pom)
   (jar)))
