# cljsjs/pikaday

[](dependency)
```clojure
[cljsjs/pickadate "3.5.6-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pickadate.date))
```

If you want to use the time picker you can require the time library as well:
```
(ns application.core
  (:require cljsjs.pickadate.time))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
