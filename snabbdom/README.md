# cljsjs/snabbdom
[](dependency)
```clojure
[cljsjs/snabbdom "0.7.4-3"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.snabbdom]
            [cljsjs.snabbdom.attributes]
            [cljsjs.snabbdom.class]
            [cljsjs.snabbdom.eventlisteners]
            [cljsjs.snabbdom.props]
            [cljsjs.snabbdom.style]))

(let [patch (js/snabbdom.init #js [(.-default js/snabbdom_attributes)
                                   (.-default js/snabbdom_class)
                                   (.-default js/snabbdom_eventlisteners)
                                   (.-default js/snabbdom_props)
                                   (.-default js/snabbdom_style)])
      vdom (js/snabbdom.h "div" #js {} "Hello World")]
  (patch (.getElementById js/document "root") vdom))

```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
