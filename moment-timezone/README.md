# cljsjs/moment-timezone

[](dependency)
```clojure
[cljsjs/moment-timezone "0.5.11-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.moment-timezone]))

(def helsinki-snapshot (.tz (js/moment) "Europe/Helsinki"))
(def stockholm-snapshot (.tz helsinki-snapshot "Europe/Stockholm"))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
