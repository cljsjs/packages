# cljsjs/klayjs

[](dependency)
```clojure
[cljsjs/klayjs "0.3.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.klayjs))
```

# Sample usage

```clojure
(ns my.namespace
  (:require [cljsjs.klayjs]))

(enable-console-print!)

(def graph
  (cljs->js {:id         "root"
             :properties {:direction "RIGHT" :spacing 40}
             :children   [{:id "n1" :width 40 :height 40}
                          {:id "n2" :width 40 :height 40}]
             :edges      [{:id "e1" :source "n1" :target "n2"}]}))

(.layout js/$klay (cljs->js {:graph   graph
                             :options {:spacing 50}
                             :success (fn [layouted] (js/console.log "Layouted."))
                             :error   (fn [err] (js/console.log "Layout error: " err))}))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
