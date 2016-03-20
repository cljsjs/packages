# cljsjs/airbrake

[](dependency)
```clojure
[cljsjs/airbrake "0.5.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.airbrake]))
  
(def client (->
             (js.airbrakeJs.Client. js/airbrakeJs {})
             (.setProject your-project-number "your-api-key")))

(.notify client (js/Error. "An error message"))
 
```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
