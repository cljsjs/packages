# cljsjs/clipboard

[](dependency)
```clojure
[cljsjs/clipboard "1.5.9-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.clipboard))

...

(defn clipboard-button [label target]
  (let [clipboard-atom (atom nil)]
    (reagent/create-class
     {:display-name "clipboard-button"
      :component-did-mount
      #(let [clipboard (new js/Clipboard (reagent/dom-node %))]
         (reset! clipboard-atom clipboard)
         (debugf "Clipboard mounted"))
      :component-will-unmount
      #(when-not (nil? @clipboard-atom)
         (.destroy @clipboard-atom)
         (reset! clipboard-atom nil)
         (debugf "Clipboard unmounted"))
      :reagent-render
      (fn []
        [:button.clipboard
         {:data-clipboard-target target}
         label])})))

(defn home-page []
  [:div [:h2 "Welcome to clipboard-test"]
   [:div {:id "copy-this"} "Testing"]
   [clipboard-button "Copy" "#copy-this"]
   [:div [:a {:href "/about"} "go to about page"]]])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
