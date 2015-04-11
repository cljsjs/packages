# cljsjs/hammer

[](dependency)
```clojure
[cljsjs/hammer "2.0.4-4"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.hammer))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
