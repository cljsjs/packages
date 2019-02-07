# cljsjs/leaflet-gesture-handling

[](dependency)
```clojure
[cljsjs/leaflet-gesture-handling "1.1.8-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.leaflet-gesture-handling))
```

## Externs Generation

Externs are generated with https://jmmk.github.io/javascript-externs-generator/

1. Loaded https://unpkg.com/leaflet@1.3.4/dist/leaflet-src.js
2. Loaded https://unpkg.com/leaflet-gesture-handling@1.1.8/dist/
3. Entered `leafletGestureHandling` as externed object
4. Included generated extern in `resources/cljsjs/common/leaflet-gesture-handling.ext.js`

## Usage Example with Reagent & react-leaflet

```clojure
(ns example.map
  (:require [leaflet :as leaflet]
            [react-leaflet :as react-leafet]
            [cljsjs.leaflet-gesture-handling]
            [reagent.core :as r]))

(def Map (r/adapt-react-class react-leaflet/Map))

(defn example-map []
  [map/Map
   {;; leaflet options
    :center #js [60.0 20.0]
    :max-zoom 15
    :min-zoom 10
    ;; enable gesture handling
    :gesture-handling true}])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
