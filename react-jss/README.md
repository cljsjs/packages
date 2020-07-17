# cljsjs/react-jss

[](dependency)
```clojure
[cljsjs/react-jss "10.3.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-jss))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [react-jss :as react-jss]))
```
