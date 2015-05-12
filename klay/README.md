# cljsjs/klay

[](dependency)
```clojure
[cljsjs/klay "0.3.2-0"] ;; latest release as per 27 MAR 2015
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.klay))
```

# Sample usage

Included a sample because usage might not be as straightforward concerning
the Javascript objects that need to be passed in. Passing an incomplete configuration
object might also end up with seamingly irrelevant error messages. Note that `map` keys
can be supplied many forms. Finally, the number of `#js`-es makes it look clunky, feel free
to improve upon that.

```clojure
(ns my.namespace
  (:require [cljsjs.klay]))

(enable-console-print!)

(def graph
  #js {"id"         "root"
       "properties" #js {"direction" "RIGHT" "spacing" 40}
       "children"   #js [#js {"id" "n1" "width" 40 "height" 40}
                         #js {"id" "n2" "width" 40 "height" 40}]
       "edges"      #js [#js {"id" "e1" "source" "n1" "target" "n2"}]})
       
(.layout js/$klay #js {:graph   graph
                       :options #js {:spacing 50}
                       :success (fn [layouted] (js/console.log "Layouted."))
                       :error   (fn [err] (js/console.log "Layout error: " err))})
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
