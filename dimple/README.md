# cljsjs/dimple

[](dependency)
```clojure
[cljsjs/dimple "2.1.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.dimple))
```

No proper externs yet - just figuring things out at the moment....

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
