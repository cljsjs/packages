# cljsjs/react-datepicker

[](dependency)
```clojure
[cljsjs/react-datepicker "1.4.0-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.react-datepicker]))

(def date-picker (.createFactory js/React (.-default js/DatePicker)))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
