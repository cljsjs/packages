# cljsjs/vega-tooltip

[](dependency)
```clojure
[cljsjs/vega-tooltip "0.12.0-0"] ;; release for vega 3.3.1
[cljsjs/vega "3.3.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vega-tooltip))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
