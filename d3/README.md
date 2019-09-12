# cljsjs/d3

[](dependency)
```clojure
[cljsjs/d3 "5.12.0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.d3))
```

Uses externs provided by `federico-b/d3-externs`, many thanks!

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
