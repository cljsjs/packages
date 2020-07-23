# cljsjs/bignumber

[](dependency)
```clojure
[cljsjs/bignumber "9.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bignumber))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require ["bignumber.js" :as BigNumber]))
```

Example usage from Clojurescript:

```clojure
(ns example.core
  (:require ["bignumber.js" :as BigNumber]))

(extend-type BigNumber
  IEquiv
  (-equiv [this other]
    (.isEqualTo this other)))

(let [x (BigNumber. 123.4567)
      y (BigNumber. "123456.7e-3")
      z (BigNumber. x)]
  (= x y z))
;; => true
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
