# cljsjs/firebase-node

DEPRECATED:
firebase-node is now distributed in the cljs/firebase pacakge, use that instead.

[](dependency)
```clojure
[cljsjs/firebase-node "2.4.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.firebase-node))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
