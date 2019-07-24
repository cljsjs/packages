# cljsjs/material-ui

https://github.com/dmtrKovalenko/date-io


[](dependency)
```clojure
[cljsjs/date-io "1.3.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require date-io-moment))
```

```clojure
(ns application.core
  (:require date-io-date-fns))
```

```clojure
(ns application.core
  (:require date-io-luxon))
```

```clojure
(ns application.core
  (:require date-io-dayjs))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
