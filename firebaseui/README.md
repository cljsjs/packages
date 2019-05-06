# cljsjs/firebaseui

Provides firebaseui-web

[](dependency)
```clojure
[cljsjs/firebaseui "3.6.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so in `.cljs` files:

```clojure
(ns application.core
  (:require [cljsjs.firebaseui]))
```

# CSS file
You need to set up the `.css` file separately in your project. For more information please see https://github.com/firebase/firebaseui-web

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Maintenance

Bump the version number in build.boot,
the source and externs are downloaded from npm.
Bump the `cljsjs/firebase` dependency version in `build.boot` if needed.
