# cljsjs/screenfull

[](dependency)
```clojure
[cljsjs/screenfull "4.2.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.screenfull))
```

Example:

```clojure
(js/screenfull.request (js/document.getElementById "foo-id"))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
