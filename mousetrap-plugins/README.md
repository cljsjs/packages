# cljsjs/mousetrap-plugins

[](dependency)
```clojure
[cljsjs/mousetrap-plugins "1.6.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.mousetrap-plugins)
```

A Bundle of Mousetrap and the existing plugins pause and record

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
