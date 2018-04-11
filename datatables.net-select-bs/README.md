<<<<<<< HEAD:datatables-bs/README.md
# cljsjs/dataloader

[Datatables]() is a generic utility to be used as part of your application's data fetching layer to provide a consistent API over various backends and reduce requests to those backends via batching and caching.
=======
# cljsjs/datatables-select
>>>>>>> [datatables.net-bs] fixed proper names and dependencies:datatables.net-select-bs/README.md

[](dependency)
```clojure
[cljsjs/datatables-select "1.2.5-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.datatables-select))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
