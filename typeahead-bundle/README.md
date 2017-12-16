# cljsjs/typeahead-bundle

[](dependency)
```clojure
[cljsjs/typeahead-bundle "0.11.1-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.typeahead-bundle))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
