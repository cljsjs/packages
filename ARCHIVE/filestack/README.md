# cljsjs/filestack

[](dependency)
```clojure
[cljsjs/filestack "3.5.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.filestack))
```

Documentation for Filestack can be found [on the Filestack documentation site](https://www.filestack.com/docs/).

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
