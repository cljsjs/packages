(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.12")
(def +version+ (str +lib-version+ "-0"))

(deftask package []
  (comp

   (download :url "https://raw.githubusercontent.com/mrchimp/tock/master/tock.js"
             :checksum "5bd332e6f9e37317d92b85c4131bca46")
   (download :url "https://raw.githubusercontent.com/mrchimp/tock/master/tock.min.js"
             :checksum "44aba8ca78ae523b4b26e5f78e320c44")

   (sift :move {#"^tock\.js"       "cljsjs/tock/development/tock.inc.js"
                #"^tock\.min.\.js" "cljsjs/tock/production/tock.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.tock")

   (pom)
   (jar)))
