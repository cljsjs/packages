# cljsjs/highcharts

[](dependency)
```clojure
[cljsjs/highcharts "4.1.10-2"] ;; latest release
```
[](/dependency)

Note that this packages jQuery `1.11.3` by default.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.highcharts))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
