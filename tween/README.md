# cljsjs/tween

[](dependency)
```clojure
[cljsjs/tween "16.3.1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.tween))
```

See example project https://github.com/sonwh98/four

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
