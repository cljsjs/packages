# cljsjs/kld-intersections

[](dependency)
```clojure
[cljsjs/kld-intersections "0.1.1-0"] ;; latest release
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
  (:require cljsjs.kld-intersections))

  ;; intersection with a segment to the center
  (js/Intersection.intersectShapes
    (js.IntersectionParams.newCircle (js/Point2D. 5 1) 1)
    (js/IntersectionParams.newLine (js/Point2D. 1 4) (js/Point2D. 5 1)))
```

[reference]: http://www.quazistax.com/testIntersection.html
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
