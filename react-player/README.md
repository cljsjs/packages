# cljsjs/react-player

[](dependency)
```clojure
[cljsjs/react-player "1.6.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-player))
```

Reagent example:

```clojure
(def react-player  (reagent/adapt-react-class js/ReactPlayer))

(defn player []
  [:div
    [react-player {:url "https://www.youtube.com/watch?v=rI8tNMsozo0"}]])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
