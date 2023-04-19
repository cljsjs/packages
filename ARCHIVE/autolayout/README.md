# cljsjs/autolayout

[](dependency)
```clojure
[cljsjs/autolayout "0.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.autolayout))
```

Documentation for the autolayout lib can be found [on its github page](https://github.com/IjzerenHein/autolayout.js/blob/master/docs/AutoLayout.md)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
