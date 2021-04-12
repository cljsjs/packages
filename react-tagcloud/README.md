# cljsjs/react-tagcloud


[](dependency)
```clojure
[cljsjs/react-tagcloud "2.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
;example usage

(ns application.core
  ;You can use :refer, :as, or js-interops via js/ReactTagcloud
  (:require [react-tagcloud :refer [TagCloud]]))

(defn view []
 [:div "Minimal Test "
  ;Define Cloud
  [:> TagCloud
       {:min-size 12
        :max-size 35
        :tags [{:value "TEST1" :count 38}
               {:value "TEST2" :count 28}
               {:value "TEST3" :count 18}
               {:value "TEST4" :count 8}]
        :on-click (fn [tag] (js/alert (str tag " selected!")))}]])

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
