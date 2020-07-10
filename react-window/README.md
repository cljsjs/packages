# cljsjs/react-window

[](dependency)
```clojure
[cljsjs/react-window "1.8.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require
   [react-window :refer [FixedSizeList]]
   [reagent.core :as r]))

(defn hello-table []
  [:div {:style {:max-height 420
                 :overflow :auto}}
   [:> FixedSizeList
    {:item-count 1000
     :height 150
     :item-size 25}
    (r/reactify-component
      (fn [{:keys [index style]}]
        [:div {:style style}
         (str "Item " index)]))]])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
