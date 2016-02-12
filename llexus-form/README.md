# cljsjs/llexus-form

[](dependency)
```clojure
[cljsjs/llexus-form "0.7.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

[Llexus-form](https://github.com/little-arhat/llexus-form).

```clojure
(ns application.core
  (:require cljsjs.llexus-form))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
