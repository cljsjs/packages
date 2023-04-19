# cljsjs/plotly

[](dependency)
```clojure
[cljsjs/plotly "1.45.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can use the packaged library like this:

```clojure
(ns application.core
  (:require cljsjs.plotly))

(defn draw-plot
  []
  (js/Plotly.newPlot
   "containerDiv"
   (clj->js [{:x ["2013-10-04 22:23:00" "2013-11-04 22:23:00" "2013-12-04 22:23:00" ]
              :y [4 5 6]
              :type "line"}])
   (clj->js {:margin {:t 0}})))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
