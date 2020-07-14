# cljsjs/react-virtualized-auto-sizer

[](dependency)
```clojure
[cljsjs/react-virtualized-auto-sizer "1.0.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require
   [react-virtualized-auto-sizer :as AutoSizer]
   [reagent.core :as r]))

(defn hello-autosize []
  [:div
   {:style {:height 100
            :width 100
            :resize :both
            :overflow :auto
            :border "1px solid"}}
   [:> AutoSizer
    {}
    (fn [dims]
      (let [{:keys [height width] :as dims} (js->clj dims :keywordize-keys true)]
        (r/as-element [:div (str width "x" height)])))]])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
