# cljsjs/rc-slider

[](dependency)
```clojure
[cljsjs/rc-slider "9.7.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.rc-slider))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

### Todo

Webpack externals should be cleaned up (pulled out) into new cljsjs projects. specifically

rc-utils, warning, and rc-tooltop
