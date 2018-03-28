# cljsjs/benchmark

[](dependency)
```clojure
[cljsjs/benchmark "2.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.benchmark))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
