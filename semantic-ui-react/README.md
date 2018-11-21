# cljsjs/semantic-ui-react

http://react.semantic-ui.com

[](dependency)
```clojure
[cljsjs/semantic-ui-react "0.83.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.semantic-ui-react))
```

Currently the only extern declared is `semanticUIReact`. All
components are available via properties of `js/semanticUIReact` and
can be accessed via `goog.object/get` and
`goog.object/getValueByKeys`.

[Example][OpenSourcery] and [Example][OpenSourcery2]:

```clojure
(ns re-frame-semantic-ui-react-github-widget.views
  ;; Other requires omitted...
  (:require [cljsjs.semantic-ui-react]
            [goog.object]))

;; Easy handle to the top-level extern for semantic-ui-react
(def semantic-ui js/semanticUIReact)

(defn component
  "Get a component from sematic-ui-react:
    (component \"Button\")
    (component \"Menu\" \"Item\")"
  [k & ks]
  (if (seq ks)
    (apply goog.object/getValueByKeys semantic-ui k ks)
    (goog.object/get semantic-ui k)))

(def container      (component "Container"))
(def button         (component "Button"))
(def segment        (component "Segment"))
(def dimmer         (component "Dimmer"))
(def loader         (component "Loader"))
(def message        (component "Message"))
(def message-header (component "Message" "Header"))
;; etc...

;; Reagent usage:
(defn view []
  [:> button {:onClick #(println "Hello world")} "Press Me"])
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[OpenSourcery]: https://www.opensourcery.co.za/2017/02/12/using-semantic-ui-react-with-re-frame/
[OpenSourcery2]: https://www.opensourcery.co.za/2018/04/22/passing-around-components-with-reagent-and-semantic-ui/
