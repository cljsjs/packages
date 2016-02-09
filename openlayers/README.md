# cljsjs/openlayers

[](dependency)
```clojure
[cljsjs/openlayers "3.13.0"] ;; latest release
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

## Configuration

OpenLayers defines some extra JSDoc annotations that will trigger generation of lots a warning during compilation. You can avoid those by defining them as part of your compiler configuration with `:closure-extra-annotations #{"api" "observable"}`.

OpenLayers also can be tweaked via various closure defines. By choosing the proper subset of functionnality the final JS size can be significantly reduced.
To rely on the default (canvas based) renderer use:

```clojure
:closure-defines {:goog.DEBUG false
                  :ol.ENABLE_DOM false
                  :ol.ENABLE_VECTOR false
                  :ol.ENABLE_PROJ4JS false
                  :ol.ENABLE_WEBGL false}}
```

Dig the [source code](https://github.com/openlayers/ol3/blob/master/src/ol/ol.js) for more defines.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
