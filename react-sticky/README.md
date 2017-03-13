# cljsjs/react-sticky

[](dependency)
```clojure
[cljsjs/react-sticky "5.0.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-sticky))
```

Calling react sticky example
```clojure
(js/React.createElement js/ReactSticky.StickyContainer
   ..props.. (js/React.createElement js/ReactSticky.Sticky
        #js {:onStickyStateChange #(println "Im so sticky!")}
        ...dom element to stick...))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
