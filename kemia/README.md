# cljsjs/kemia

[](dependency)
```clojure
[cljsjs/kemia "0.2.0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing Kemia  **as a Closure library**.
This means requiring parts of it is done in a similar fashion to
requiring parts of the Closure library itself:

```clojure
(ns application.core
  (:require [goog.dom :as dom]          ; Closure
            [kemia.model.Atom :as Atom]))   ; Kemia
```

Kemia homepage can be found [here](http://kemia.github.io/)

