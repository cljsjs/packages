# cljsjs/bigfraction

[](dependency)
```clojure
[cljsjs/bigfraction "4.0.12-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bigfraction))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require ["fraction.js/bigfraction.js" :as BigFraction]))
```

This works too:

```clojure
(ns application.core
  (:require [cljsjs.bigfraction :as BigFraction]))
```

[Fraction][fractionjs] is a rational number library written in JavaScript.
[BigFraction][bigfractionjs] is an API-identical version of Fraction, bundled
inside the [fraction.js][fractionjs] npm dependency. From the
[site][fractionjs]:

Tired of inprecise numbers represented by doubles, which have to store rational
and irrational numbers like PI or sqrt(2) the same way? Obviously the following
problem is preventable:

```javascript
1 / 98 * 98 // = 0.9999999999999999
```

If you need more precision or just want a fraction as a result, have a look at
*Fraction.js*:

```javascript
var Fraction = require('fraction.js/bigfraction.js');

Fraction(1).div(98).mul(98) // = 1
```

Internally, numbers are represented as *numerator / denominator*, which adds
just a little overhead. However, the library is written with performance in mind
and outperforms any other implementation, as you can see [here][benchmark]. This
basic data-type makes it the perfect basis for [Polynomial.js][polyjs] and
[Math.js][mathjs].

Example usage from Clojurescript:

```clojure
(ns example.core
  (:require ["fraction.js/bigfraction.js" :as BigFraction]))

(extend-type BigFraction
  IEquiv
  (-equiv [this other]
    (.equals this other)))

(defn fraction
  [num denom]
  (BigFraction. num denom))

(= (fraction 50 100)
   (fraction 1 2))
;; => true
```

[benchmark]: http://jsperf.com/convert-a-rational-number-to-a-babylonian-fractions/28
[fractionjs]: https://github.com/infusion/Fraction.js
[bigfractionjs]: https://github.com/infusion/Fraction.js/blob/master/bigfraction.js
[polyjs]: https://github.com/infusion/Polynomial.js
[mathjs]: https://github.com/josdejong/mathjs
