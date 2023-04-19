# cljsjs/tableauwdc

[](dependency)
```clojure
[cljsjs/tableauwdc "2.2.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.tableauwdc))
```

When working on this wrapper on Windows, beware [boot-cljsjs/48](https://github.com/cljsjs/boot-cljsjs/issues/48)!

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
