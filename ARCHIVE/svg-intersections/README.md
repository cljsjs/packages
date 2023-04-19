# cljsjs/svg-intersections

[](dependency)
```clojure
[cljsjs/svg-intersections "0.3.0-0"] ;; latest release
```
[](/dependency)

[Intersections][reference] is a JavaScript object used to capture the results of the
intersection of two Shape objects. Class methods perform the actual
intersections and use only Point2D objects as parameters. This makes this class
useful stand-alone uses where you don't want to use the 2D Geometry library.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.svg-intersections))

;; intersection with a segment to the center
(js/SvgIntersection.intersect
  (js/SvgIntersection.shape "circle" #js {:cx 5 :cy 1 :r 1})
  (js/SvgIntersection.shape "line" #js {:x1 1 :y1 4 :x2 5 :y2 1}))
```

[reference]: http://www.quazistax.com/testIntersection.html
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
