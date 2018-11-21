# cljsjs/c3

[](dependency)
```clojure
[cljsjs/c3 "0.6.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.c3))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
