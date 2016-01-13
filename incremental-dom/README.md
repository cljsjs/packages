# cljsjs/incremental-dom

[](dependency)
```clojure
[cljsjs/incremental-dom "0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing incremental-dom **as a Closure library**, which means it can undergo all the closure-compiler optimisations.

This means requiring it is done in a similar fashion to requiring parts of the Closure library itself:

```clojure
(ns application.core
  (:require [goog.dom :as dom]          ; Closure
            [incremental-dom :as inc])) ; Incremental Dom
```

Currently, incremental-dom produces a few warnings on compilation. Some of these are resolved by setting the `:language-in` option to `:ecmascript5` in your cljsbuild configuration, but some seem to be to do with Babel stripping some parentheses from the ES2015 code.
