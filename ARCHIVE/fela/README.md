# cljsjs/fela

[](dependency)
```clojure
[cljsjs/fela "4.3.5-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.fela))
```

# Example

```clojure
(def renderer (.createRenderer js/Fela))

(defn some-style-rule
  [props]
  #js {:color (:color props)})

(.renderRule js/Fela some-style-rule {:color "blue"})
```
