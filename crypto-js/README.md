# cljsjs/d3

[](dependency)
```clojure
[cljsjs/crypto-js "4.1.1-0"] ;; latest release
```

Note that there are two dashes in the version since the crypto-js version is "3.1.9-1"

[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.crypto-js))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
