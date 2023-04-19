# cljsjs/qrcode-generator

[](dependency)
```clojure
[cljsjs/qrcode-generator "1.4.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.qrcode-generator]))

(.createDataURL (doto (js/qrcode 2 \L) (.addData src "Alphanumeric") (.make)) 8 0)

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
