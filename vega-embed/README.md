# cljsjs/vega-embed

[](dependency)
```clojure
[cljsjs/vega-embed "3.0.0-rc7-0"] ;; latest release
[cljsjs/vega "3.0.1-0"] ;; latest release
[cljsjs/vega-lite "2.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vega)
  (:require cljsjs.vega-lite)
  (:require cljsjs.vega-embed))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
