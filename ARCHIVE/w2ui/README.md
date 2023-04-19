# cljsjs/w2ui

[](dependency)
```clojure
[cljsjs/w2ui "1.4.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.w2ui))

```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps


For default-style use w2ui.css, which is not included in this package to enable using custom styling.
For example you can use: https://unpkg.com/w2ui@1.4.3/w2ui-1.4.3.min.css