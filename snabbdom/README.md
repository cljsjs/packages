# cljsjs/snabbdom
[](dependency)
```clojure
[cljsjs/snabbdom "3.0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [snabbdom :refer [h init] :as snabbdom]))

(let [patch (init #js [(.-attributesModule snabbdom)
                       (.-classModule snabbdom)
                       (.-eventListenersModule snabbdom)
                       (.-propsModule snabbdom)
                       (.-styleModule snabbdom)])
      vdom (h "div" #js {} "Hello World")]
  (patch (.getElementById js/document "root") vdom))

```
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
