# cljsjs/muuri-react

[](dependency)
```clojure
[cljsjs/muuri "0.9.0-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.muuri))
```

Documentation for the muuri library can be found [on its github page](https://github.com/haltu/muuri)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps