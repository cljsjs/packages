# cljsjs/pixi

[](dependency)
```clojure
[cljsjs/pixi "3.0.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pixi))

(def asset-loader js/PIXI.loader)
```

Externs were generated using http://www.dotnetwise.com/Code/Externs/

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
