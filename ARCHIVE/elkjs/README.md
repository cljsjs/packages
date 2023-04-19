# cljsjs/elkjs

[](dependency)
```clojure
[cljsjs/elkjs "0.3.0-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.elkjs))
```

Sample use:

```clojure
(defn compute-layout [graph options success error]
     (->  (.layout (js/ELK.) (clj->js graph) (clj->js (or options {})))
          (.then #(success (js->clj % :keywordize-keys true)))
          (.catch #(error (js->clj % :keywordize-keys true)))))
```
