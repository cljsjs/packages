# cljsjs/webcomponents

This is a cljsjs package for https://github.com/webcomponents/webcomponentsjs

[](dependency)
```clojure
[cljsjs/webcomponents-lite "0.7.21-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.webcomponents-lite))
```
[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
