# cljsjs/airbrake

[](dependency)
```clojure
[cljsjs/airbrake "0.5.8-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.airbrake]))

(def client
  (js/airbrakeJs.Client. #js{:projectId your-project-number
                             :projectKey "your-api-key"}))

(.notify client (js/Error. "An error message"))

```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
