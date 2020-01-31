# cljsjs/react-easy-crop

https://github.com/ricardo-ch/react-easy-crop


[](dependency)
```clojure
[cljsjs/react-easy-crop "1.17.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-easy-crop))

(def cropper (aget js/ReactEasyCrop "default")

...

(let [crop (reagent.core/atom #js {:x 1 :y 1})]
    (fn []
      [:> cropper {:image "img/test.jpg"
                   :crop @crop
                   :onCropChange #(reset! crop %)}]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
