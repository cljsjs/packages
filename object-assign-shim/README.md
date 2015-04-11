# cljsjs/object-assign-shim

[](dependency)
```clojure
[cljsjs/object-assign-shim "0.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.object-assign-shim))
```
