# cljsjs/applicationinsights

[](dependency)
```clojure
[cljsjs/applicationinsights "1.0.14-0"] ;; latest release
```
[](/dependency)

```clojure
(ns application.core
  (:require cljsjs.applicationinsights))


(defonce init-insights
  (let [conf     (clj->js {:config {:instrumentationKey "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxx"}})
        init     (js/Microsoft.ApplicationInsights.Initialization. conf)
        insights (.loadAppInsights init)]
    (.trackPageView insights)))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies