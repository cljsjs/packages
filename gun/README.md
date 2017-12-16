# cljsjs/gun

[](dependency)
```clojure
[cljsjs/gun "0.6.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature of the Clojurescript compiler. After adding the above dependency to your project +you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.gun))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
