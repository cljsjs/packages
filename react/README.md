# cljsjs/react

[](dependency)
```clojure
[cljsjs/react "18.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [react :as react]))
```

# cljsjs/react-with-addons

React-with-addons has been [deprecated](https://facebook.github.io/react/docs/addons.html).
For animation utils use [react-transition-group](../react-transition-group) package instead.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
