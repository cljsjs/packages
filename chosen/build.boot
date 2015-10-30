(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.4.2-1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/chosen
       :version     +version+
       :description "jQuery plugin that makes long, unwieldly select boxes much more user-friendly."
       :url         "http://harvesthq.github.io/chosen/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      "https://github.com/harvesthq/chosen/releases/download/1.4.2/chosen_v1.4.2.zip"
             :checksum "dda575a545dc97924bebfa2a070bf993"
             :unzip    true)
   (sift :move {#"^chosen\.jquery\.js"      "cljsjs/chosen/development/chosen.inc.js"
                #"^chosen\.jquery\.min\.js" "cljsjs/chosen/production/chosen.min.inc.js"
                #"^chosen\.css"             "public/chosen/css/chosen.css"
                #"^chosen\.min\.css"        "public/chosen/css/chosen.min.css"
                #"^chosen-sprite.png"       "public/chosen/css/chosen-sprite.png"
                #"^chosen-sprite@2x.png"    "public/chosen/css/chosen-sprite@2x.png"})
   (sift :include #{#"^cljsjs" #"^public"})
   (deps-cljs :name "cljsjs.chosen"
              :requires ["cljsjs.jquery"])))
