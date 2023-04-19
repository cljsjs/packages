# cljsjs/turndown

Convert HTML into Markdown with JavaScript.

[Formerly known as to-markdown]

[](dependency)
```clojure
[cljsjs/turndown "4.0.1-0"] ;; latest release
```
[](/dependency)

Use in your app:

```clojure
(ns application.core
  (:require cljsjs.turndown))

(def turndown-service (js/TurndownService. options))
(def md (.turndown turndown-service string-of-html))
```
