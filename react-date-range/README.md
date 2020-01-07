# cljsjs/react-date-range

[](dependency)
```clojure
[cljsjs/react-date-range "1.0.0-beta2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-date-range))
```

Usage might look something like this:

```clojure
(js/React.createElement
 js/ReactDateRange.DateRangePicker
 #js{:ranges   #js [#js {:startDate (js/Date.)
                         :endDate   (js/Date.)
                         :key       "selection"}]
     :onChange prn})
```

You can also use those 2 provided CSS files:

```clojure
;; Development
cljsjs/react-date-range/development/styles.inc.css
cljsjs/react-date-range/development/theme/default.inc.css

;; Production
cljsjs/react-date-range/production/styles.min.inc.css
cljsjs/react-date-range/production/theme/default.min.inc.css

```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
