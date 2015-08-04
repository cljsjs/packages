# cljsjs/pako

[](dependency)
```clojure
[cljsjs/pako "0.2.7-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pako))
```
# Usage

```clojure
; to deflate and return a Uint8Array:
(.gzip js/pako source-str (clj->js {:name "loerun ipsum"}))
```

```clojure
; to deflate and return a string:
(.gzip js/pako source-str (clj->js {:name "loerun ipsum" :text true}))
```

```clojure
; to inflate and return a string:
(.ungzip js/pako deflated-unint8array (clj->js {:text true}))
```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
