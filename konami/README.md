# cljsjs/konami

[](dependency)
```clojure
[cljsjs/konami "1.6.2-0"] ;; latest release
```
[](/dependency)

## Usage

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.konami))
```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
