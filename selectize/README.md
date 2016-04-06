# cljsjs/selectize

[](dependency)
```clojure
[cljsjs/selectize "0.12.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.selectize]))

(.selectize (js/jQuery (.getElementById js/document "#dropdown")))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
