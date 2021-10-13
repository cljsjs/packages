# cljsjs/react-d3-cloud


[](dependency)
```clojure
[io.github.cljsjs/react-d3-cloud "1.0.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
;example usage

(ns application.core
  ;You can use :refer, :as, or js-interops via js/ReactTagcloud
  (:require [cljsjs.react-d3-cloud]))

(def d3-cloud (reagent/adapt-react-class js/ReactD3Cloud))

(defn view []
  (let [data [{:text "Hey" :value 1000}
              {:text "lol", :value 200}
              {:text "first impression", :value 800}
              {:text "very cool", :value 1000000}
              {:text "duck", :value 10}]]
    [:div "Minimal Test "
     ;Define Cloud
     [d3-cloud {:data data
                :font-size (fn [word]
                             (* (js/Math.log2 (aget word "value"))
                                5))
                :width 500
                :height 500}]]))

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
