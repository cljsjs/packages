# cljsjs/matter

[](dependency)
```clojure
[cljsjs/matter "0.8.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.matter))
```

Documentation for the matter.js lib can be found [on its github page](https://github.com/liabru/matter-js)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
