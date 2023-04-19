# cljsjs/phaser

[](dependency)
```clojure
[cljsjs/phaser "3.18.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs]
feature of the ClojureScript compiler. After adding the above
dependency to your project you can require the packaged library like
so:

```clojure
(ns application.core
  (:require cljsjs.phaser))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps


## Externs

Externs were generated initially by using the
[jmmk/javascript-externs-generator](https://github.com/jmmk/javascript-externs-generator)
tool.
