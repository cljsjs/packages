# cljsjs/jstat

[](dependency)
```clojure
[cljsjs/jstat "1.9.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jstat))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [jstat :as jstat]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
