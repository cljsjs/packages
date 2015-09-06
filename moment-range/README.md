# cljsjs/moment

[](dependency)
```clojure
[cljsjs/moment-range "2.0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.moment-range))

;;Create a date range for the current month
(.range (js/moment) "month")

;;Create a range for an ISO 8601 time interval string
(.range js/moment "2015-09-01T00:00:00+10:00/2015-09-30T23:59:59+10:00")


;;Create a range for two arbitrary moments
(.range js/moment (.startOf (js/moment) "month") (.endOf (js/moment) "month"))
```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
