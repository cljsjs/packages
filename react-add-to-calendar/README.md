# cljsjs/react-add-to-calendar

[](dependency)
```clojure
[cljsjs/react-add-to-calendar "0.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [[reagent.core :as r]
             [cljsjs.react-add-to-calendar]]))

(def react-add-to-calendar (r/adapt-react-class (aget js/ReactAddToCalendar "default")))

(defn main-panel []
  (fn []
    [:div.container
     [:h1 "Check for the calendar presence"]
     [react-add-to-calendar {:event {:title "Important event"
                                     :description "Don't forget"
                                     :start-time "2018-09-16T20:15:00-04:00"
                                     :end-time "2018-09-16T21:45:00-04:00"}}]]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
