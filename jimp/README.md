# cljsjs/jimp

[](dependency)
```clojure
[cljsjs/jimp "0.2.27"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

#### Important note
`jimp` has different builds for browser and node.js usage. Here we are using `browser` version.


```clojure
(ns application.core
  (:require cljsjs.jimp))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
