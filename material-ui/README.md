# cljsjs/material-ui

https://material-ui-next.com/

[](dependency)
```clojure
[cljsjs/material-ui "1.0.0-beta.33"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.material-ui
            cljsjs.material-ui-svg-icons))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
