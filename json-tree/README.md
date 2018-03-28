# cljsjs/json-tree

[](dependency)
```clojure
[cljsjs/json-tree "0.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.json-tree))

(def tree (.create js/JsonTree #js {} dom-element))

(.loadData tree (clj->js {...}))
```

Externs were generated manually, so it does not include all the api and only create & loadData are fully tested.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
