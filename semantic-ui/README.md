# cljsjs/semantic-ui

This is a cljsjs package for https://github.com/Semantic-Org/Semantic-UI

[](dependency)
```clojure
[cljsjs/semantic-ui "2.1.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.semantic-ui))
```
[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
