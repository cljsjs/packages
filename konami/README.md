# cljsjs/konami

A cljsjs package for [konami-js][konamijs] JavaScript library.

[](dependency)
```clojure
[cljsjs/konami "1.6.3-0"] ;; latest release
```
[](/dependency)

## Usage

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require, and use, the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.konami))

(def easter-egg (js/Konami. (fn [] (js/alert "Hello Konami code!"))))
```

An example project using the konami package can be seen [here][konamitest].

[konamijs]: https://konamijs.mand.is/
[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[konamitest]: https://github.com/28/konami-cljs-test
