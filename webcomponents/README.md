# cljsjs/webcomponents

This is a cljsjs package for https://github.com/webcomponents/webcomponentsjs

[](dependency)
```clojure
[cljsjs/webcomponents "0.7.21-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.webcomponents))
```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
