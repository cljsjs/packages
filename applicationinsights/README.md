# cljsjs/applicationinsights

[](dependency)
```clojure
[cljsjs/applicationinsights "1.0.14-0"] ;; latest release
```
[](/dependency)

```clojure
(ns application.core
  (:require [applicationinsights :refer [ApplicationInsights]]))


(defonce insights
  (let [Initialization (aget ApplicationInsights "Initialization")
        conf           (clj->js {:config {:instrumentationKey "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxx"}})
        init           (Initialization. conf)]
    (.loadAppInsights init)))


(.trackPageview insights)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
