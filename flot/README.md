# cljsjs/flot

[](dependency)
```clojure
[cljsjs/flot "0.8.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.flot))
```

You can also require individual packaged plugins:

```
cljsjs.flot.plugins.canvas
cljsjs.flot.plugins.categories
cljsjs.flot.plugins.crosshair
cljsjs.flot.plugins.errorbars
cljsjs.flot.plugins.fillbetween
cljsjs.flot.plugins.image
cljsjs.flot.plugins.navigate
cljsjs.flot.plugins.pie
cljsjs.flot.plugins.resize
cljsjs.flot.plugins.selection
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
