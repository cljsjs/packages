# cljsjs/pouchdb-find

[](dependency)
```clojure
[cljsjs/pouchdb-find "7.0.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pouchdb-find))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Generating Externs

The externs were written manually following the `pouchdb-find` README.
