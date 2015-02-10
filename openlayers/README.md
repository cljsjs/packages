# cljsjs/openlayers

[](dependency)
```clojure
[cljsjs/openlayers "3.1.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing OpenLayers **as a Closure library**.
This means requiring parts of it is done in a similar fashion to
requiring parts of the Closure library itself:

```clojure
(ns application.core
  (:require [goog.dom :as dom]          ; Closure
            [ol.animation :as anim]))   ; OpenLayers
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

