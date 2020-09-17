# cljsjs/highcharts

[](dependency)
```clojure
[cljsjs/highcharts "7.0.3-1"] ;; latest release
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
- cljsjs.highcharts.modules.annotations-advanced
- cljsjs.highcharts.modules.arrow-symbols
- cljsjs.highcharts.modules.boost
- cljsjs.highcharts.modules.broken-axis
- cljsjs.highcharts.modules.bullet
- cljsjs.highcharts.modules.current-date-indicator
- cljsjs.highcharts.modules.cylinder
- cljsjs.highcharts.modules.data
- cljsjs.highcharts.modules.debugger
- cljsjs.highcharts.modules.drag-panes
- cljsjs.highcharts.modules.draggable-points
- cljsjs.highcharts.modules.drilldown
- cljsjs.highcharts.modules.exporting
- cljsjs.highcharts.modules.export-data
- cljsjs.highcharts.modules.full-screen
- cljsjs.highcharts.modules.funnel
- cljsjs.highcharts.modules.gantt
- cljsjs.highcharts.modules.grid-axis
- cljsjs.highcharts.modules.heatmap
- cljsjs.highcharts.modules.histogram-bellcurve
- cljsjs.highcharts.modules.item-series
- cljsjs.highcharts.modules.networkgraph
- cljsjs.highcharts.modules.no-data-to-display
- cljsjs.highcharts.modules.no-data-to-display
- cljsjs.highcharts.modules.offline-exporting
- cljsjs.highcharts.modules.offline-exporting
- cljsjs.highcharts.modules.oldie-polyfills
- cljsjs.highcharts.modules.oldie
- cljsjs.highcharts.modules.overlapping-datalabels
- cljsjs.highcharts.modules.parallel-coordinates
- cljsjs.highcharts.modules.pareto
- cljsjs.highcharts.modules.pathfinder
- cljsjs.highcharts.modules.pattern-fill
- cljsjs.highcharts.modules.price-indicator
- cljsjs.highcharts.modules.sankey
- cljsjs.highcharts.modules.series-label
- cljsjs.highcharts.modules.solid-gauge
- cljsjs.highcharts.modules.sonification
- cljsjs.highcharts.modules.static-scale
- cljsjs.highcharts.modules.stock-tools
- cljsjs.highcharts.modules.stock
- cljsjs.highcharts.modules.streamgraph
- cljsjs.highcharts.modules.sunburst
- cljsjs.highcharts.modules.tilemap
- cljsjs.highcharts.modules.timeline
- cljsjs.highcharts.modules.treegrid
- cljsjs.highcharts.modules.treemap
- cljsjs.highcharts.modules.variable-pie
- cljsjs.highcharts.modules.variwide
- cljsjs.highcharts.modules.vector
- cljsjs.highcharts.modules.venn
- cljsjs.highcharts.modules.windbarb
- cljsjs.highcharts.modules.wordcloud
- cljsjs.highcharts.modules.xrange

Notes:

- The extern is generated without 3d, more or modules, so probably it is missing something
    - Send fixes as PR!
- Style by CSS version is packaged separately: https://github.com/cljsjs/packages/tree/master/highcharts-css
    - That package doesn't currently package the modules

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
