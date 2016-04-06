# cljsjs/parinfer

[](dependency)
```clojure
[cljsjs/parinfer "1.5.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.parinfer]))

(println (.-text (js/parinfer.indentMode "(foo\nbar)")))
(println (.-text (js/parinfer.parenMode "(foo\nbar)")))
```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
