# cljsjs/raven

[](dependency)
```clojure
[cljsjs/raven "3.26.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.raven))
```

Documentation for the raven-js lib can be found [on its github page](https://github.com/getsentry/raven-js)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
