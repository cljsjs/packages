# cljsjs/numeral

[](dependency)
```clojure
[cljsjs/numeral "2.0.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.numeral))

(-> .256 js/numeral (.format "$0.00")) ;; $0.26
```

## Locales

Each locale from Numeral.js is provided as separate foreign dependency namespace.
You should be able to set Numeral to use locales if you first require them.

```clojure
(ns application.core
  (:require cljsjs.numeral cljsjs.numeral.locales.fi))

(.locale js/numeral "fi")
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
