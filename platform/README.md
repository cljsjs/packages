# cljsjs/platform

[](dependency)
```clojure
[cljsjs/platform "1.0.0-0"] ;; latest release
```
[](/dependency)

Note: Google does not version its api library since they prefer people to use is through their cdn. Therefore, the checksum may be incorrect. If you run into this problem, follow these steps:

1. wget https://apis.google.com/js/platform.js
2. run boot package
3. copy the correct checksum from the log
4. replace the checksum in build.boot with the current one

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.aws-sdk-js))
```

Documentation for the platform lib can be found [on this page](https://developers.google.com/+/web/api/javascript)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
