# cljsjs/firebase

[](dependency)
```clojure
[cljsjs/firebase "7.5.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.firebase]))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [firebase.app :as firebase-app])
  (:require [firebase.auth :as firebase-auth]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Maintenance

Bump the version number in build.boot, the source and externs are downloaded from npm.
