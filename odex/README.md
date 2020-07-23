# cljsjs/odex

[](dependency)
```clojure
[cljsjs/odex "2.0.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.odex))
```

This is a port to JavaScript (actually, TypeScript) of [E. Hairer and G.
Wanner's implementation][impl] of the [Gragg-Bulirsch-Stoer][gbs] method of
integrating systems of differential equations. The original code is written in
idiomatic Fortran; this code tries to present an idiomatic JavaScript interface
while preserving all the of the virtues of the original code, including its
speed, configurability, and compact memory footprint.

Here's an example of how to replicate the demo from the [Github README][readme]:

```clojure
(ns example.core
  (:require [cljsjs.odex]))

(defn routine [x y] y)

(let [s (js/odex.Solver. 1)]
  (.solve s routine 0 [1] 1))
```

[impl]: http://jsperf.com/convert-a-rational-number-to-a-babylonian-fractions/28
[gbs]: https://en.wikipedia.org/wiki/Bulirsch%E2%80%93Stoer_algorithm
[readme]: https://github.com/littleredcomputer/odex-js#examples
