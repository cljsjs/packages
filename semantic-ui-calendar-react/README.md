# cljsjs/semantic-ui-calendar-react

https://github.com/arfedulov/semantic-ui-calendar-react

[](dependency)
```clojure
[cljsjs/semantic-ui-calendar-react "0.15.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.semantic-ui-calendar-react]))
```

The only extern declared is `SemanticUiCalendarReact`. All
components are available using something like `(aget js/SemanticUiCalendarReact "DateInput")`.
Here's an example of using the date-input component with reagent:

```clojure
(ns example.semantic-ui-calendar-react
  (:require [cljsjs.semantic-ui-calendar-react]
            [reagent.core :as r]))

(defn component [k]
  (r/adapt-react-class
    (aget js/SemanticUiCalendarReact k)))

(def date-input (component "DateInput"))
(def date-time-input (component "DateTimeInput"))
(def dates-range-input (component "DatesRangeInput"))
(def time-input (component "TimeInput"))
(def year-input (component "YearInput"))
(def month-input (component "MonthInput"))
(def month-range-input (component "MonthRangeInput"))

;; Reagent usage:

(def state (r/atom nil))

(defn date-selector-that-logs-selection []
  [date-input {:value @state :onChange #(reset! state (.-value %2))}])

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps