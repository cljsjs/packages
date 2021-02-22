# cljsjs/ag-grid-enterprise - The JavaScript Datagrid for Enterprise

React Toolbox depends on React with Addons, so, to be able to use it, you not only have to depend on
cljsjs/ag-grid-enterprise:

[](dependency)
```clojure
[cljsjs/ag-grid-enterprise "25.0.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.ag-grid-enterprise))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Upgrading

When upgrading ag-grid, you need to regenerate the externs:
1. Find the version of AG Grid you want to update to.
2. Find the URL for ag-grid.js, such as: https://unpkg.com/ag-grid-enterprise@25.0.1/dist/ag-grid-enterprise.js
3. Go to http://jmmk.github.io/javascript-externs-generator
4. Paste the URL for ag-grid.js and click load.
5. Name the JavaScript object agGrid.
6. Click "Extern!"
7. Copy the JavaScript value to resources/cljsjs/ag-grid-enterprise/common/ag-grid-enterprise.ext.js
