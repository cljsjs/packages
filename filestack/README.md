# cljsjs/filestack

[](dependency)
```clojure
[cljsjs/filestack "0.0.1-0"] ;; latest release
```
[](/dependency)

**Note:** Filestack does not publish versioned artifacts, for that reason `0.0.1` is used as placeholder.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.filestack))
```

Documentation for Filestack can be found [on the Filestack documentation site](https://www.filestack.com/docs/).

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
