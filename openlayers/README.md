# cljsjs/openlayers

[](dependency)
```clojure
[cljsjs/openlayers "7.5.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing OpenLayers **as a Closure library**.
This means requiring parts of it is done in a similar fashion to
requiring parts of the Closure library itself:

```clojure
(ns application.core
  (:require [goog.dom :as dom]          ; Closure
            [cljsjs.openlayers]))               ; OpenLayers
```

Example usage related to: https://openlayers.org/en/latest/examples/accessible.html
```clojure
(def ol-map (aget js/ol "Map"))
(def ol-tile-layer (aget js/ol "layer" "Tile"))
(def ol-view (aget js/ol "View"))
(def ol-osm-source (aget js/ol "source" "OSM"))

(defn- test-map []
  (r/create-class
   {:component-did-mount
    (fn []
      (ol-map.
       (clj->js {:layers [(ol-tile-layer. #js{:source (ol-osm-source.)})]
                 :target "map"
                 :view (ol-view. #js{:center #js[0 0]
                                     :zoom 2})})))

    :reagent-render
    (fn []
      [:div {:style {:width 600
                     :height 500}}
       [:div#map.map]])}))
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
                  :ol.ENABLE_WEBGL false}
```

Dig the [source code](https://github.com/openlayers/ol3/blob/master/src/ol/ol.js) for more defines.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
