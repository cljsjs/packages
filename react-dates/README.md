# cljsjs/react-dates

This wraps up [Airbnb's react-dates widget](https://github.com/airbnb/react-dates) in a tasty CLJSJS wrapper.

An example of this being used with Reagent can be found [here](https://github.com/ddellacosta/react-dates-reagent-example).

[](dependency)
```clojure
[cljsjs/react-dates "12.2.4-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-dates))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
