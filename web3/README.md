# cljsjs/web3

[](dependency)
```clojure
[cljsjs/web3 "0.15.3-0"] ;; latest release
```
[](/dependency)

Doesn't include the full API yet.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.web3))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
