# cljsjs/highcharts

[](dependency)
```clojure
[cljsjs/highcharts-css "5.0.10-0"] ;; latest release
```
[](/dependency)

Note that this no longer includes a dependency on jQuery.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.highcharts-css))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
