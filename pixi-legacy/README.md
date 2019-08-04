# cljsjs/pixi-legacy

[](dependency)
```clojure
[cljsjs/pixi-legacy "5.1.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pixi-legacy))

(def asset-loader js/PIXI.loader)
```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

**Difference to cljsjs/pixi:**

With version 5 of pixi.js its build-logic has changed. cljsjs/pixi 5.0.0+ only supports WebGL, this dependency supports the canvas variant.
Look on there explanations for further information: https://medium.com/goodboy-digital/pixijs-v5-lands-5e112d84e510 