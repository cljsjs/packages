# cljsjs/bitauth

ClojureScript wrapper around BitPay's [BitAuth](https://github.com/bitpay/bitauth) protocol.
[](dependency)
```clojure
[cljsjs/bitauth "0.2.1-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bitauth))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
