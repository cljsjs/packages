# cljsjs/bootstrap-typeahead

[](dependency)
```clojure
[cljsjs/bootstrap-typeahead "4.0.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bootstrap-typeahead))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

## Example:

```clojure
(fn [this]
 (doto
  (js/$ (r/dom-node this)) ; <-- being used in a Reagent component
  (.typeahead (clj->js {:name ""
               :source data
               :updater (fn [obj] (println "updater:" obj))
               :displayText (fn [obj] (.-email obj))}))))
```
