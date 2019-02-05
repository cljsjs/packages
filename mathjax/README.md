# cljsjs/mathjax

[](dependency)
```clojure
[cljsjs/mathjax "2.7.5"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.mathjax))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
