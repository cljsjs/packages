# cljsjs/fela-dom

[](dependency)
```clojure
[cljsjs/fela-dom "4.3.2-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.fela-dom))
```

# Example

```clojure
(.render js/FelaDOM (.getElementById js/document "my-style-node"))
```
