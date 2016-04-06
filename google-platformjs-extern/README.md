# cljsjs/platform

[](dependency)
```clojure
[cljsjs/google-platformjs-extern "1.0.0-0"] ;; latest release
```
[](/dependency)

This package only contains the externs file. You need to provide the read code yourself.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.google-platformjs-extern))
```

Documentation for the platform lib can be found [on this page](https://developers.google.com/+/web/api/javascript)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
