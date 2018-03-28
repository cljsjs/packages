# cljsjs/hash

[](dependency)
```clojure
[cljsjs/hash "1.1.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.hash))

(-> (.sha512 js/hash)
    (.update "I'm getting hashed!")
    (.digest))
```

  [flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
