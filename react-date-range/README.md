# cljsjs/react-date-range

[](dependency)
```clojure
[cljsjs/react-date-range "0.2.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-date-range))
```

Usage might look something like this:

```clojure
(js/React.createElement
  js/ReactDateRange.DateRange
  #js {onChange: #(js/console.log %)})
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
