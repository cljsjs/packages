# cljsjs/snabbdom
[](dependency)
```clojure
[cljsjs/snabbdom "0.7.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [snabbdom :refer [init h]]
            [snabbdom.modules.attributes :as attrs]
            [snabbdom.modules.class :as class]
            [snabbdom.modules.eventlisteners :as el]
            [snabbdom.modules.props :as props]
            [snabbdom.modules.style :as style]))

(let [patch (init #js [(.-default attrs)
                       (.-default class)
                       (.-default el)
                       (.-default props)
                       (.-default style)])
      vdom (h "div" #js {} "Hello World")]
  (patch (.getElementById js/document "root") vdom))

```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
