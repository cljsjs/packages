# cljsjs/react-ultimate-pagination

[](dependency)
```clojure
[cljsjs/react-ultimate-pagination "1.2.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-ultimate-pagination))
```

This package supports `:global-exports`

```clojure
(ns application.core
  (:require [react-ultimate-pagination :refer [createUltimatePagination]]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
