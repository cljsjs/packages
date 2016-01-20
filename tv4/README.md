# cljsjs/tv4

[](dependency)
```clojure
[cljsjs/tv4 "1.2.7"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.tv4))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies