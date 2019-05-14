# cljsjs/react-giphy-selector - A very customizable react search component for picking the perfect giphy.

https://github.com/tshaddix/react-giphy-selector

[](dependency)
```clojure
[cljsjs/react-giphy-selector "0.0.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.react-giphy-selector))

;; Access with
(.-Selector js/ReactGiphySelector)
;; or
(.-ResultSort js/ReactGiphySelector)
;; or
(.-ResultSort js/ReactGiphySelector)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps