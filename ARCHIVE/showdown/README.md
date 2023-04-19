# cljsjs/showdown

[](dependency)
```clojure
[cljsjs/showdown "1.8.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.showdown))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
