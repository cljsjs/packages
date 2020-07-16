# cljsjs/react-virtuoso

[](dependency)
```clojure
[cljsjs/react-virtuoso "0.17.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [react-virtuoso :refer [Virtuoso]]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
