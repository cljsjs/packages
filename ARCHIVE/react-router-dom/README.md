# cljsjs/react-router-dom

[](dependency)
```clojure
[cljsjs/react-router-dom "5.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-router-dom))
```

The above will make `js/ReactRouterDOM` available

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
