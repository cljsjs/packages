# cljsjs/pluralize

[](dependency)
```clojure
[cljsjs/pluralize "3.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.pluralize))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
