# cljsjs/soundjs

[](dependency)
```clojure
[cljsjs/soundjs "0.6.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.soundjs))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
