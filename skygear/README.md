# cljsjs/skygear

[](dependency)
```clojure
[cljsjs/skygear "0.17.0-0"] ;; latest release
```
[](/dependency)

ClojureScript package for the [Skygear](skygear) BaaS JS SDK.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.skygear))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[skygear]: https://skygear.io
