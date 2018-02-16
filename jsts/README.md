# cljsjs/jsts

A port of the Java Topology Suite to javascript

http://bjornharrtell.github.io/jsts/

[](dependency)
```clojure
[cljsjs/jsts "1.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jsts))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
