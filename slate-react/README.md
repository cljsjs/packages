# cljsjs/slate-react

[](dependency)
```clojure
[cljsjs/slate-react "0.12.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.slate-react))
```

Documentation for the slate lib can be found [on its GitHub page](https://github.com/ianstormtaylor/slate)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
