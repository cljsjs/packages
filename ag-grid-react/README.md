# cljsjs/ag-grid-react - The JavaScript Datagrid for Enterprise

React Toolbox depends on React with Addons, so, to be able to use it, you not only have to depend on
cljsjs/ag-grid-react:

[](dependency)
```clojure
[cljsjs/ag-grid-react "25.0.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.ag-grid-react))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
