# cljsjs/tether

[](dependency)
```clojure
[cljsjs/tether "1.4.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.tether))
```

And then use it like so:

```clojure
(let [options {:element ..., :target ...}
      tether (new js/Tether (clj->js options))]
  ;do whatever to it
  (.position tether))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
