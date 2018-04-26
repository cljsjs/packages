# cljsjs/proton-js

[](dependency)
```clojure
[cljsjs/proton-js "3.1.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.proton-js))

(def emitter (js/Proton.Emitter.))
```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
