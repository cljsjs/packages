# cljsjs/hunt

[](dependency)
```clojure
[cljsjs/hunt "2.1.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.hunt))
```
Documentation for hunt can be found [here](https://jeremenichelli.github.io/hunt/)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

