# cljsjs/vega-lite

[](dependency)
```clojure
[cljsjs/vega-lite "4.0.2-0"] ;; latest release
[cljsjs/vega "4.4.0-0"] ;; latest release
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
