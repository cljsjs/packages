# cljsjs/photoswipe

[](dependency)
```clojure
[cljsjs/photoswipe "4.1.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.photoswipe]
            [cljsjs.photoswipe-ui-default]))
```

The Photoswipe default ui is a split off into a separate namespace, as seen above.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
