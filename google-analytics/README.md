# cljsjs/google-analytics

The latest release as of 2019-02-04 is "2017-09-21" according to the
[the changelog](https://developers.google.com/analytics/devguides/collection/analyticsjs/changelog).

This is converted to a semver for cljsjs like so:

[](dependency)
```clojure
[cljsjs/google-analytics "2017.09.21"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.google-analytics))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
