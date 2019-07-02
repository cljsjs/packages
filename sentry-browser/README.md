# cljsjs/sentry-browser

[](dependency)
```clojure
[cljsjs/sentry-browser "5.4.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.sentry-browser))
```

Documentation for the @sentry/browser lib can be found [on its github page](https://github.com/getsentry/sentry-javascript)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
