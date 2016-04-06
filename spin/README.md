# cljsjs/spin

[](dependency)
```clojure
[cljsjs/spin "2.3.2-0"] ;; latest release
```
[](/dependency)

ClojureScript package for the [spin.js](spin.js) utility for creating animated
progress spinners.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.spin))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[spin.js]: http://spin.js.org
