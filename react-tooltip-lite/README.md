# cljsjs/react-tooltip-lite

https://github.com/bsidelinger912/react-tooltip-lite


[](dependency)
```clojure
[cljsjs/react-tooltip-lite "1.9.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-tooltip-lite))

(def tooltip (aget js/ReactToolTipLite "default")

...
[:> tooltip {:content "Test tooltip"}
 "Test"]

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
