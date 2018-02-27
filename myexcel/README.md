# cljsjs/jszip

ClojureScript wrapper around [MyExcel][].

[](dependency)
```clojure
[cljsjs/myexcel "1.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
 (:require cljsjs.jszip))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[MyExcel]: https://github.com/jsegarra1971/MyExcel
