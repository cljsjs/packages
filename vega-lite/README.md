# cljsjs/vega-lite

[](dependency)
```clojure
[cljsjs/vega-lite "5.14.1-0"] ;; latest release
[cljsjs/vega "5.25.0-0"] ;; latest for vgl 5.14.1
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vega))
  (:require cljsjs.vega-lite))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
