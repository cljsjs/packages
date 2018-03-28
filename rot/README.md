# cljsjs/rot

ROguelike Toolkit in JavaScript. For more info, see http://ondras.github.com/rot.js.

[](dependency)
```clojure
[cljsjs/rot "0.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.rot]))

  (js/alert (.isSupported js/ROT))

```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
