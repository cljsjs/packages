# cljsjs/resumable.js

[](dependency)
```clojure
[cljsjs/resumable.js "1.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require 
   [reagent.core :as reagent]
   [cljsjs.resumable.js]))

(def r (js/Resumable.))
(defn upload []
 (let [ref (reagent/atom nil)] 
  (reagent/create-class
   {:display-name "upload-test"
    :reagent-render (fn []
                      [:button {:ref #(reset! ref %)}
                       "Upload"])
    :component-did-mount (fn []
                           (.assignBrowse r @ref)
                           (.on r "fileAdded" (fn [f] (js/console.log "File Added" f))))})))

```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
