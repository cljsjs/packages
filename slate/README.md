# cljsjs/slate

[](dependency)
```clojure
[cljsjs/slate "0.58.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.slate))
```

Documentation for the slate lib can be found [on its GitHub page](https://github.com/ianstormtaylor/slate)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
