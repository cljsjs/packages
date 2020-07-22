# cljsjs/complex

[](dependency)
```clojure
[cljsjs/complex "2.0.11-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.complex))
```

Complex.js is a well tested JavaScript library to work with [complex number
arithmetic][complex] in JavaScript. It implements every elementary complex
number manipulation function and the API is intentionally similar to
[Fraction.js][fractionjs]. Furthermore, it's the basis of
[Polynomial.js][polyjs] and [Math.js][mathjs].


[complex]: https://www.xarg.org/book/analysis/complex-numbers
[fractionjs]: https://github.com/infusion/Fraction.js
[polyjs]: https://github.com/infusion/Polynomial.js
[mathjs]: https://github.com/josdejong/mathjs
