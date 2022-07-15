# io.github.cljsjs/openlayers-ol-ext

[](dependency)
```clojure
[cljsjs/openlayers-ol-ext "3.2.28-0"] ;; latest release
```
[](/dependency)

```clojure
(ns application.core
  (:require [cljsjs.openlayers-ol-ext])) 
```

Example usage related to: http://viglino.github.io/ol-ext/examples/filter/map.filter.lego.html

```clojure
(def ol-map (aget js/ol "Map"))
(def ol-tile-layer (aget js/ol "layer" "Tile"))
(def ol-view (aget js/ol "View"))
(def ol-osm-source (aget js/ol "source" "OSM"))
(def lego-filter (aget js/ol "filter" "Lego"))

(defn- test-map []
  (r/create-class
   {:component-did-mount
    (fn []
     (let [tile-layer (ol-tile-layer. #js{:source (ol-osm-source.)})] 
      (ol-map.
       (clj->js {:layers [tile-layer]
                 :target "map"
                 :view (ol-view. #js{:center #js[0 0]
                                     :zoom 2})}))
      (.addFilter tile-layer (lego-filter. #js{:brickSize 15}))))

    :reagent-render
    (fn []
      [:div {:style {:width 600
                     :height 500}}
       [:div#map.map]])}))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
