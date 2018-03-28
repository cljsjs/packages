# cljsjs/resize-observer-polyfill

A polyfill for the Resize Observer API.

```clojure
[cljsjs/resize-observer-polyfill "1.4.2-0"] ;; latest release
```

Packages up [ResizeObserver Polyfill](https://github.com/que-etc/resize-observer-polyfill).

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.resize-observer-polyfill))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
