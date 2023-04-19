# cljsjs/ladda

[](dependency)
```clojure
[cljsjs/ladda "1.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.ladda]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
