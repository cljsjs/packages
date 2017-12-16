# cljsjs/graphiql

[](dependency)
```clojure
[cljsjs/graphiql "0.9.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.graphiql))
```

After requiring `cljsjs.graphiql`, you will be able to reference a global GraphiQL object at `js/GraphiQL`.

This package ships `graphiql.css` as a resource at path `cljsjs/graphiql/common/graphiql.css`.

```clojure
(require '[clojure.java.io :as io])

(def graphiql-css
  (slurp (io/resource "cljsjs/graphiql/common/graphiql.css")))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
