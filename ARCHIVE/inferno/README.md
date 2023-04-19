# cljsjs/inferno

[](dependency)
```clojure
[cljsjs/inferno "5.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.inferno]))

(defn init []
  (let [container (. js/document (getElementById "container"))
        v-node (.createVNode  js/Inferno 2 "div" #js {} "Inferno is working")]
    (.render js/Inferno v-node container)))

```

Several optional Inferno modules can also be required in your project as
follows


```clojure
(ns application.core
  (:require [cljsjs.inferno.create-element]
            [cljsjs.inferno.create-class]
            [cljsjs.inferno.hyperscript]))
```

Consult Inferno's [documentation](https://github.com/infernojs/inferno "Inferno") for more information about these modules.



[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
