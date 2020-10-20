# cljsjs/blueprintjs-datetime


[](dependency)
```clojure
[cljsjs/blueprintjs-datetime "3.19.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
;example usage for DateInput

(ns application.core
  ;You can use :refer, :as, or js-interops via js/BlueprintJSDatetime 
  (:require [blueprintjs-core]
            [blueprintjs-datetime :refer [DateInput]]))

;date formatting options
(def options (clj->js {:year "numeric" :month "2-digit" :day "2-digit"}))

(defn view []
  [:div "BlueprintJS minimal Datetime test"
   [:> DateInput {:placeholder "dd.mm.yyyy"
                  ;formatting of selected date
                  :formatDate (fn [d] (.toLocaleDateString d "de-DE" options))
                  ;parse of actual input
                  :parseDate (fn [d] (js/Date. d))}]])

```

#### Info:
Package includes @blueprintjs/datetime. You also need a css for styling from: https://unpkg.com/@blueprintjs/datetime@3.19.3/lib/css/blueprint-datetime.css

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
