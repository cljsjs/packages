# cljsjs/three

[](dependency)
```clojure
[cljsjs/three "0.0.70-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.three))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

