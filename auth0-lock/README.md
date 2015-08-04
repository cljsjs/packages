# cljsjs/auth0 -lock

[](dependency)
```clojure
[cljsjs/auth0-lock "7.7.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.auth0-lock))
```

Documentation for the auth0-lock lib can be found [on its github page](https://github.com/auth0/lock)

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
