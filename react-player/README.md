# cljsjs/react-player

[](dependency)
```clojure
[cljsjs/react "15.1.1-0"] ;; latest release
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
    [react-player {:url "http://rateless.net/~dormo/moo-test-files/big_buck_bunny.mp4"}]])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
