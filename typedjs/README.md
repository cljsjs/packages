# cljsjs/typedjs

This is a cljsjs package for https://github.com/mattboldt/typed.js/

[](dependency)
```clojure
[cljsjs/typedjs "1.1.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.typedjs))
```
[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
