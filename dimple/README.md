# cljsjs/d3

[](dependency)
```clojure
[cljsjs/dimple "2.1.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.dimple))
```

No proper externs yet - just figuring things out at the moment....



