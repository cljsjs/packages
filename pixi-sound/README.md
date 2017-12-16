# cljsjs/pixi-sound

[](dependency)
```clojure
[cljsjs/pixi-sound "1.4.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pixi-sound))

(def pixi-sound js/PIXI.sound)
```

Externs were generated manually, so it does not include all the api.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
