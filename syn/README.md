# cljsjs/syn
[](dependency)
```clojure
[cljsjs/syn "0.1.2"] ;; latest release
```
[](/dependency)

ClojureScript package for [syn](syn) - Standalone Synthetic Event Library

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.syn))
```
[syn]: https://github.com/bitovi/syn
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
