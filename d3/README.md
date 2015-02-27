# cljsjs/d3

[](dependency)
```clojure
[cljsjs/d3 "3.5.5-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.d3))
```

Uses externs provided by `federico-b/d3-externs`, many thanks!

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

