# cljsjs/textures

[](dependency)
```clojure
[cljsjs/textures "2.0.0"] ;; latest release
```

[](/dependency)

```clojure
(ns application.core
  (:require cljsjs.colorbrewer :as [colorbrewer]))
  
(-> colorbrewer
  (.-YlGn)
  (.-3))
  
;; ["#f7fcb9","#addd8e","#31a354"]
```
