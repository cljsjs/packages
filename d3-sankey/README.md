# cljsjs/d3-sankey

[](dependency)
```clojure
[cljsjs/d3-sankey "0.7.1-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can use the packaged library like so:

```clojure
(ns application.core
  (:require
    [d3]
    [d3.sankey :as sankey]))

(sankey)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
