# cljsjs/long

[](dependency)
```clojure
[cljsjs/long "3.0.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.long))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
