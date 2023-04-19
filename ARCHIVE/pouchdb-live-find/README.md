# cljsjs/pouchdb-live-find
 +
[](dependency)
```clojure
[cljsjs/pouchdb-live-find "0.2.0-0"] ;; latest release
 +```
 +[](/dependency)
 +
 +This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
 +of the ClojureScript compiler. After adding the above dependency to your project
 +you can require the packaged library like so:
 +
 +```clojure
 +(ns application.core
 +  (:require cljsjs.pouchdb-live-find))
 +```
 +
 +[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
 +
 +## Generating Externs
 +
 +The externs were written manually following the `pouchdb-live-find` README.
