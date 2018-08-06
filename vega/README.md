# cljsjs/vega

[](dependency)
```clojure
[cljsjs/vega "3.3.1-0"] ;; last B4 4.x release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vega))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
