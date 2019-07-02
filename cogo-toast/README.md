# cljsjs/cogo-toast

https://github.com/Cogoport/cogo-toast


[](dependency)
```clojure
[cljsjs/cogo-toast "3.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.cogo-toast))
   
  ;Example 
  [[:button {:on-click #(.info (aget js/CogoToast "default") "My Toast")} "Example"]  
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

For Styling embed css from https://github.com/Cogoport/cogo-toast/blob/master/src/styles/styles.css or implement your own styles (Separated for custom styling)