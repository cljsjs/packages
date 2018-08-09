# cljsjs/qs

[](dependency)
```clojure
[cljsjs/qs "6.5.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.qs]))

(def obj (js/qs.parse "a=b"))

(println obj)

(def string (js/qs.stringify obj))

(println string)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
