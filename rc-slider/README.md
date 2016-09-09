# cljsjs/rc-slider

[](dependency)
```clojure
[cljsjs/rc-slider "4.0.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.rc-slider))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

### Todo

Webpack externals should be cleaned up (pulled out) into new cljsjs projects. specifically

rc-utils, warning, and rc-tooltop