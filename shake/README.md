# cljsjs/bankersbox

[](dependency)
```clojure
[cljsjs/shake "1.2.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.shake))
```

Uses externs provided by `https://github.com/jmmk/javascript-externs-generator`, many thanks!

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
