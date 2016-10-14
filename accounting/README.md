# cljsjs/accounting

[](dependency)
```clojure
[cljsjs/accounting "0.4.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.accounting))

...

(defn accounting-button [label target]
  (let [accounting-atom (atom nil)]
    (reagent/create-class
     {:display-name "accounting-button"
      :component-did-mount
      #(let [accounting (new js/Accounting (reagent/dom-node %))]
         (reset! accounting-atom accounting)
         (debugf "Accounting mounted"))
      :component-will-unmount
      #(when-not (nil? @accounting-atom)
         (.destroy @accounting-atom)
         (reset! accounting-atom nil)
         (debugf "Accounting unmounted"))
      :reagent-render
      (fn []
        [:button.accounting
         {:data-accounting-target target}
         label])})))

(defn home-page []
  [:div [:h2 "Welcome to accounting-test"]
   [:div {:id "copy-this"} "Testing"]
   [accounting-button "Copy" "#copy-this"]
   [:div [:a {:href "/about"} "go to about page"]]])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
