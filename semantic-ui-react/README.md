# cljsjs/semantic-ui-react

http://react.semantic-ui.com

[](dependency)
```clojure
[cljsjs/semantic-ui-react "0.67.1-0"] ;; latest release
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

Example:

```clojure
(ns application.core
  (:require cljsjs.semantic-ui-react
            goog.object
            [reagent.core :as r))

(def semantic-ui js/semanticUIReact)

;; Top-level component:
(def button (goog.object/get semantic-ui "Button"))

;; Nested component:
(def menu-item (goog.object/getValueByKeys semantic-ui "Menu" "Item"))

;; Reagent usage:
(defn view []
  [:> button {:onClick #(println "Hello world")} "Press Me"])
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
