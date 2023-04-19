# cljsjs/topojson

[](dependency)
```clojure
[cljsjs/topojson "1.6.18-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.d3 ; d3 not required automatically
            cljsjs.topojson))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
