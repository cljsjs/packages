# cljsjs/bitauth

ClojureScript wrapper around BitPay's [BitAuth](https://github.com/bitpay/bitauth) protocol.

To include in your `project.clj`:

[](dependency)
```clojure
[cljsjs/bitauth "0.2.3-xcthulhu"] ;; latest release
```
[](/dependency)

As indicated, `"0.2.2-xcthulhu"` is not an official release. It is based off of a fork of BitPay's repository maintained by xcthulhu here: [https://github.com/xcthulhu/bitauth](https://github.com/xcthulhu/bitauth)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bitauth))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
