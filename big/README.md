# cljsjs/big

[](dependency)
```clojure
[cljsjs/big "5.2.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.big))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require ["big.js" :as Big]))
```

Example usage from Clojurescript:

```clojure
(ns example.core
  (:require ["big.js" :as Big]))

(extend-type Big
  IEquiv
  (-equiv [this other]
    (.eq this other)))

(let [x (Big. 123.4567)
      y (Big. "123456.7e-3")
      z (Big. x)]
  (= x y z))
;; => true
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
