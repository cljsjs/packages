# cljsjs/pixi-viewport

[](dependency)
```clojure
[cljsjs/pixi-viewport "3.4.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pixi-viewport))

(def viewport (js/PIXI.extras.Viewport)
```
Contains complete PIXI with the extension of pixi-viewport in it.

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
