# cljsjs/vis-network

[](dependency)
```clojure
[cljsjs/vis-network "6.4.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vis-network))
```

For Styling and Images you need css and images from https://unpkg.com/browse/vis-network@6.4.4/dist/ (Its not in the Package, so that you have the ability to change something)


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
