# cljsjs/js-joda-timezone


This adds timezone database info to to js-joda.

Add the dependency along with cljsjs/js-joda to enable zone-related functionality

[](dependency)
```clojure
[io.github.cljsjs/js-joda-timezone "2.17.2-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require
     ["@js-joda/core"]
     ["@js-joda/timezone"]))

```

## Info on how to build

### Externs

None.

### Replacements

None.

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
