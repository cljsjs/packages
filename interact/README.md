# cljsjs/interact

[](dependency)
```clojure
[cljsjs/interact "1.2.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.interact]))

(.draggable (js/interact "#drag-me") true)

```

Consult Interact's [documentation](https://github.com/taye/interact.js "Interact") for more information about this module.



[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
