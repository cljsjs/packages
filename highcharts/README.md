# cljsjs/highcharts

[](dependency)
```clojure
[cljsjs/highcharts "7.0.1-0"] ;; latest release
```
[](/dependency)

Note that this no longer includes a dependency on jQuery.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.highcharts))
```

This package also provides following namespaces:

- cljsjs.highcharts.highcharts-more
- cljsjs.highcharts.highcharts-3d
- cljsjs.highcharts.modules.accessibility
- cljsjs.highcharts.modules.annotations
- cljsjs.highcharts.modules.boost
- cljsjs.highcharts.modules.broken-axis
- cljsjs.highcharts.modules.data
- cljsjs.highcharts.modules.exporting
- cljsjs.highcharts.modules.drilldown
- cljsjs.highcharts.modules.funnel
- cljsjs.highcharts.modules.heatmap
- cljsjs.highcharts.modules.networkgraph
- cljsjs.highcharts.modules.no-data-to-display
- cljsjs.highcharts.modules.offline-exporting
- cljsjs.highcharts.modules.solid-gauge
- cljsjs.highcharts.modules.treemap

Notes:

- The extern is generated without 3d, more or modules, so probably it is missing something
    - Send fixes as PR!
- Style by CSS version is packaged separately: https://github.com/cljsjs/packages/tree/master/highcharts-css
    - That package doesn't currently package the modules

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
