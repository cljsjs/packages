# io.github.cljsjs/html-to-image-mod

A fork from https://github.com/bubkoo/html-to-image/ which fixes issue #345 (Scrollbar positions and styling)

[](dependency)
```clojure
[io.github.cljsjs/html-to-image-mod "1.11.11-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require html-to-image-mod))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
