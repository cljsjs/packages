# cljsjs/graphql

[graphql](https://github.com/graphql/graphql-js) is JavaScript reference implementation for GraphQL, a query language for APIs created by Facebook. 

[](dependency)
```clojure
[cljsjs/graphql "0.13.1-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.graphql))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
