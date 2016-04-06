# cljsjs/google-analytics

The latest release as of 2015-09-22 is "2015-04-13" according to the
[the changelog](https://developers.google.com/analytics/devguides/collection/analyticsjs/changelog).

This is converted to a semver for cljsjs like so:

[](dependency)
```clojure
[cljsjs/google-analytics "2015.04.13-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.google-analytics))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
