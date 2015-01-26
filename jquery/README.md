# cljsjs/jquery

[](dependency)
```clojure
[cljsjs/jquery "1.8.2-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jquery))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

