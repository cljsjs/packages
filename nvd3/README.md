# cljsjs/nvd3

This is a cljsjs package for [nvd3](http://nvd3.org/).

Add the following dependency to the `:dependencies` in your `project.clj` file:

[](dependency)
```clojure
[cljsjs/nvd3 "1.8.2-1"] ;; latest release
```
[](/dependency)

This jar also requires the d3 jar, which can be included along with nvd3 in one of your `:main namespaces as such:

```clojure
(ns application.core
  (:require cljsjs.d3)
  (:require cljsjs.nvd3))
```

## CSS Assets

This jar requires additional CSS assets:

* `nv.d3.css`
* `nv.d3.min.css`

`cljsjs` currently [doesn't have a way to include CSS assets in the generated jar](https://github.com/cljsjs/packages/wiki/Non-JS-Assets). So the CSS files will have to be used as follows:

```html
<!-- Directly in your index.html file. -->
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/novus/nvd3/v1.8.1/build/nv.d3.css">
<!-- or the min version -->
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/novus/nvd3/v1.8.1/build/nv.d3.min.css">
```

## Usage Example
Using clojure:

```clojure
(defn line-chart
  [line-chart-data]
  (.addGraph js/nv
             (fn []
               (let [chart (.. js/nv -models lineChart
                               (useInteractiveGuideline true)
                               (color (clj->js ["#900"])))]
                 (.. chart -xAxis
                     (axisLabel "Time (ms)")
                     (tickFormat (.format js/d3 ",r")))
                 (.. chart -yAxis
                     (axisLabel "Voltage (v)")
                     (tickFormat (.format js/d3 ".02f")))
                 (.. js/d3 (select "#line-chart svg")
                     (datum (clj->js line-chart-data))
                     (call chart))))))
```

JS equivalent:

```javascript
function lineChart(lineChartData) {
  nv.addGraph(function() {
    var chart = nv.models.lineChart()
      .useInteractiveGuideline(true)
      .color(["#900"]);

    chart.xAxis
      .axisLabel('Time (ms)')
      .tickFormat(d3.format(',r'));

    chart.yAxis
      .axisLabel('Voltage (v)')
      .tickFormat(d3.format('.02f'));

    d3.select('#line-chart svg')
      .datum(lineChartData)
      .call(chart);

    return chart;
  });
};
```