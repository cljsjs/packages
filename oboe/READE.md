# cljsjs/oboe
```clojure
[cljsjs/oboe "2.1.2-1"] ;; latest release
```
Packages up [Oboe.js](http://oboejs.com/).

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.oboe))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
