# cljsjs/react-motion

[](dependency)
```clojure
[cljsjs/react-motion "0.5.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-motion))
```

This package also supports `:global-exports`:

```
(ns application.core
  (:require [react-motion :as rm :refer [Motion]]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
