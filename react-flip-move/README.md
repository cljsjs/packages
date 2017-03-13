# cljsjs/react-flip-move

[](dependency)
```clojure
[cljsjs/react-flip-move "2.7.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-flip-move))
```

Here's a simple reagent example:

```clojure
(def flip-move (r/adapt-react-class js/FlipMove))

(defn my-list [data]
  [:div
    [:ul 
      [flip-move {:easing "cubic-bezier(0, 0.7, 0.8, 0.1)"}
        (map (fn [[k v]] (vector :li {:key k} v)) (:list @data))]]

    [:button.btn.btn-primary
      {:on-click #(swap! data update-in
                         [:list] (fn [s] 
                                   (into {} (shuffle (seq s)))))}
      "Shuffle"]])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
