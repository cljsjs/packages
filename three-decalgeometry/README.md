# cljsjs/three-decalgeometry

three-decalgeometry depends on three so you'll need to add both to your project:

[](dependency)
```clojure
[cljsjs/three-decalgeometry "0.1.0-0"] ;; latest release
[cljsjs/three-decalgeometry "0.1.0-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.three-decalgeometry))
```

And then reference the class like:

```clojure
(def decal (js/THREE.DecalGeometry.))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
