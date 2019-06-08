# cljsjs/re-resizable

https://github.com/bokuweb/re-resizable


[](dependency)
```clojure
[cljsjs/re-resizable "5.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.re-resizable))
   
  ;Example 
  [:> (aget js/ReResizable "Resizable")
      {:style {:background-color "red"}
       :defaultSize {:width 200
                     :height 200}}
      "test"]    
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
