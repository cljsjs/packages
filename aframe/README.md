# cljsjs/aframe

[](dependency)
```clojure
[cljsjs/aframe "0.6.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.aframe))
```

Uses externs generated with by [`jmmk`'s Javascript Externs Generator'](https://github.com/jmmk/javascript-externs-generator).

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
