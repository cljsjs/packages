# cljsjs/ag-grid-community - The JavaScript Datagrid for Enterprise

React Toolbox depends on React with Addons, so, to be able to use it, you not only have to depend in
cljsjs/ag-grid-community:

[](dependency)
```clojure
[cljsjs/ag-grid "19.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require [cljsjs.ag-grid]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Upgrading

When upgrading ag-grid, you need to regenerate the externs:
1. Go to https://cdnjs.com/libraries/ag-grid/<THE-VERSION> such as https://cdnjs.com/libraries/ag-grid/10.0.1
2. Find the URL for ag-grid.js, such as: https://cdnjs.cloudflare.com/ajax/libs/ag-grid/8.2.0/ag-grid.js
3. Go to http://jmmk.github.io/javascript-externs-generator
4. Paste the URL for ag-grid.js and click load.
5. Name the JavaScript object agGrid.
6. Click "Extern!"
6. Copy the JavaScript value to resources/cljsjs/ag-grid/common/ag-grid.ext.js
