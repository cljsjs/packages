# cljsjs/ansiparse

[](dependency)
```clojure
[cljsjs/ansiparse "0.0.5-1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.ansiparse]))

(defn parse-ansi-string [s]
  (js/ansiparse s))
```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
