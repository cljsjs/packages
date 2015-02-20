(set-env!
 :source-paths   #{"src"}
 :resource-paths #{"html" "conf"}
 :dependencies   '[[adzerk/boot-cljs "0.0-2814-0" :scope "test"]
                   [org.clojure/clojurescript "0.0-2850" :scope "test"]
                   [pandeiro/boot-http "0.6.3-SNAPSHOT" :scope "test"]
                   [reagent "0.5.0-alpha3"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]])

(deftask compile-cljs []
  (cljs :optimizations :advanced))

(deftask publish [] ; *** WIP ***
  (comp
   (compile-cljs)
   ;; TODOs
   ;; - sift to produce only HTML and JS file necessary
   ;; - link 'target' and gh-pages branch via git subtree
   ;;   eg: http://gohugo.io/tutorials/github-pages-blog/#toc_7
   ;; - instructions on pushing changes
   ))

;;
;; Development
;;
(deftask compile-cljs-dev []
  (cljs :optimizations :none, :source-map true))

(deftask dev []
  (comp
   (watch)
   (compile-cljs-dev)
   (serve :dir "target")))
