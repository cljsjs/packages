# cljsjs/buffer

[](dependency)
```clojure
[cljsjs/buffer "5.1.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.buffer))

(js/buffer.Buffer.from "I'm almost a buffer!")
```

  [flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
