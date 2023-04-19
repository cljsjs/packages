# cljsjs/vis-timeline

[](dependency)
```clojure
[cljsjs/vis-timeline "6.3.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.vis-timeline))
```

For Styling and Images you need css from https://unpkg.com/browse/vis-timeline@6.2.4/dist/ (Its not in the Package, so that you have the ability to change something)


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
