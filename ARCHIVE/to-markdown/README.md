# cljsjs/to-markdown

An HTML to Markdown converter written in JavaScript.

[](dependency)
```clojure
[cljsjs/to-markdown "1.3.0-0"] ;; latest release
```
[](/dependency)

Use in your app:

```clojure
(ns application.core
  (:require cljsjs.to-markdown))

(def my-markdown (js/toMarkdown my-html-string))
```

