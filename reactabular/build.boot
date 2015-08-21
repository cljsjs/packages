(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
		  [cljsjs/lodash "3.10.1-0"]
		  [cljsjs/react "0.13.3-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.6.6-0")

(task-options!
  pom  {:project     'cljsjs/reactabular
        :version     +version+
        :description "A React tabular component."
        :url         "http://bebraw.github.io/reactabular/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

;; Note that the dist/ version of Reactabular doesn't quite work, it needs the following change
;; near the beginning:
;;		root["Reactabular"] = factory(root["lodash"], root["react/addons"]);
;; ->
;;		root["Reactabular"] = factory(root["_"], root["React"]);


(deftask package []
  (deps-cljs :name "cljsjs.reactabular"
             :requires ["cljsjs.lodash" "cljsjs.react"]))
