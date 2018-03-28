# cljsjs/parinfer

[](dependency)
```clojure
[cljsjs/parinfer "3.11.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.parinfer]))

(println (.-text (js/parinfer.indentMode "(foo\nbar)")))
(println (.-text (js/parinfer.parenMode "(foo\nbar)")))
```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
