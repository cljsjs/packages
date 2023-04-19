# cljsjs/ipfs

[](dependency)
```clojure
[cljsjs/ipfs-api "18.1.1-0"] ;; latest release
```
[](/dependency)

Doesn't include the full API yet.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.ipfs))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
