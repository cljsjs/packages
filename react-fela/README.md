# cljsjs/react-fela

[](dependency)
```clojure
[cljsjs/react-fela "4.3.5-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-fela))
```

# Example

```clojure

(defn some-style-rule
  [props]
  #js {:color (:color props)})

(def styled-component
  (js/ReactFela.createComponent some-style-rule))

```
