# cljsjs/noty

[](dependency)
```clojure
[cljsjs/noty "3.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.noty))
```
or
```clojure
(ns application.core
  (:require cljsjs.noty-light))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

Do note that you have to include the css files yourself, both `noty.css` and the themes.
