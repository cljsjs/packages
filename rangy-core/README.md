# cljsjs/rangy-core

[](dependency)
```clojure
[cljsjs/rangy-core "1.3.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.rangy-core]))
```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
