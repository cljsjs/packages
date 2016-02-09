# cljsjs/filesaverjs

[](dependency)
```clojure
[cljsjs/filesaverjs "1.20150507.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.filesaverjs))

...

(defn download [filename content & [mime-type]]
  (let [mime-type (or mime-type (str "text/plain;charset=" (.-characterSet js/document)))
        blob (new js/Blob
                  (clj->js [content])
                  {:type mime-type})]
    (js/saveAs blob filename)))

(defn download-button []
  [:button
   {:on-click #(download "test.txt" "Hello world!\n")}
   "Download"])

(defn home-page []
  [:div [:h2 "Welcome to filesaverjs-test"]
   [:div {:id "copy-this"} "Testing"]
   [download-button]
   [:div [:a {:href "/about"} "go to about page"]]])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
