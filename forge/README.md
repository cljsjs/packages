# cljsjs/forge

[](dependency)
```clojure
[cljsjs/forge "0.6.38-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.forge))

(defn do-hash [s]
  (.toHex (-> (.create js/forge.md.sha512)
              (.update s)
              (.digest))))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
