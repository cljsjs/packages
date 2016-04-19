# cljsjs/dragula

[](dependency)
```clojure
[cljsjs/dragula "3.6.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.dragula))
```

Documentation for the dragula lib can be found [on its github page](https://github.com/bevacqua/dragula)

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
