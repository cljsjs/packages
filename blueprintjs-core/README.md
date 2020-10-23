# cljsjs/blueprintjs-core


[](dependency)
```clojure
[cljsjs/blueprintjs-core "3.34.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
;example usage: For Icons and Toast

(ns application.core
  ;You can use :refer, :as, or js-interops via js/BlueprintJS or js/BlueprintJSIcons 
  (:require [blueprintjs-core :refer [Icon Intent Position] :as bcore]
            [blueprintjs-icons :refer [IconNames]])

;Define Toast
(def toast (.create bcore/Toaster {:className "recipe-toaster" :position (aget Position "TOP")}))

(defn view []
 [:div "BlueprintJS minimal Test - Click the icon "
  ;Define Icon
  [:> Icon {:icon (aget IconNames "GRAPH") ;Displayed Icon
            :iconSize (aget Icon "SIZE_LARGE") ;Icon Size
            :intent (aget Intent "PRIMARY") ;Icon Color
            ;Show Toast on on-click
            :on-click #(.show toast (clj->js {:message "Test Toast"}))}]])

```

#### Info:
Package includes @blueprintjs/core and @blueprintjs/icons, because the core requires icons.
You also need a css for styling from: https://unpkg.com/@blueprintjs/core@3.34.0/lib/css/blueprint.css

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
