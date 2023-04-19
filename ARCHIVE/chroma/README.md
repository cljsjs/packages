# cljsjs/chroma

[](dependency)
```clojure
[cljsjs/chroma "1.1.1-0"] ;; latest release
```

[](/dependency)
```clojure
(ns application.core
  (:require cljsjs.chroma :as [chroma]))
  
(-> (js/chroma "#D4F880")
  (.darken)
  (.hex))
  
;; #9BC04B
```
