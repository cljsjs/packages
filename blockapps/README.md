# cljsjs/blockapps-js

[blockapps-js](https://github.com/blockapps/blockapps-js) is a library that exposes a number of functions for interacting with the Blockchain via the BlockApps API. Currently it has strong support for compiling Solidity code, creating the resulting contract, and querying its variables or calling its functions through Javascript code.

[](dependency)
```clojure
[cljsjs/blockapps "2.2.5-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.blockapps))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
