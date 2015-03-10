# cljsjs/c3

[](dependency)
```clojure
[cljsjs/c3 "0.4.9-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.c3))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

