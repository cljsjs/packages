# cljsjs/llexus-validate

[](dependency)
```clojure
[cljsjs/llexus-validate "0.1.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

[Llexus-validate](https://github.com/little-arhat/llexus-validate).

```clojure
(ns application.core
  (:require cljsjs.llexus-validate))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
