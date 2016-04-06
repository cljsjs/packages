# cljsjs/dialog-polyfill

[](dependency)
```clojure
[cljsjs/dialog-polyfill "0.4.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.dialog-polyfill))

...

(defn get-dialog [name]
  (.querySelector js/document (str "#" name)))

(defn show-dialog [name]
  (when-let [dialog (get-dialog name)]
    (.showModal dialog)
    dialog))

(defn close-dialog [name]
  (when-let [dialog (get-dialog name)]
    (.close dialog)))

(defn my-dialog []
  [dialog
   {:id "my-dialog"}
   [:h1 "This is a modal dialog"]
   [:button {:on-click #(close-dialog "my-dialog")} "Ok"]])

(defn dialog-button []
  [:button
   {:on-click #(show-dialog "my-dialog")}
   "Dialog"])

(defn home-page []
  [:div [:h2 "Welcome to clipboard-test"]
   [my-dialog]
   [dialog-button]])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
