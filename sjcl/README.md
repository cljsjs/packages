# cljsjs/sjcl

[](dependency)
```clojure
[cljsjs/sjcl "1.0.6-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.sjcl))
```

Documentation for the sjcl lib can be found [here](http://bitwiseshiftleft.github.io/sjcl/)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
