# cljsjs/tabulator

[](dependency)
```clojure
[cljsjs/tabulator "4.9.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.tabulator))

...

(new js/Tabulator 
     <DOM-NODE>
     #js {})

```



[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
