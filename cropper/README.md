# cljsjs/cropper
[](dependency)
```clojure
[cljsjs/cropper "0.8.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.cropper))
```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
