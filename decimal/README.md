# cljsjs/decimal

[](dependency)
```clojure
[cljsjs/decimal "5.0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.decimal))
```

The library is similar to [bignumber.js][bignumber], but here precision is
specified in terms of significant digits rather than decimal places, and all
calculations are rounded to the precision (similar to Python's decimal module)
rather than just those involving division.

This library also adds the trigonometric functions, among others, and supports
non-integer powers, which makes it a significantly larger library than
[bignumber.js][bignumber] and the even smaller [big.js][big].

Example usage from Clojurescript:

```clojure
(ns example.core
  (:require [cljsjs.decimal]))

(extend-type js/Decimal
  IEquiv
  (-equiv [this other]
    (.equals this other)))

(defn decimal [x]
  (js/Decimal. x))

(let [x (decimal 123.4567)
      y (decimal "123456.7e-3")
      z (decimal x)]
  (= x y z))
;; => true
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[bignumber]: https://github.com/MikeMcl/bignumber.js/
[big]: https://github.com/MikeMcl/big.js/
