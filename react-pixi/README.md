# cljsjs/react-pixi

[](dependency)
```clojure
[cljsjs/react-pixi "0.9.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-pixi))
```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
