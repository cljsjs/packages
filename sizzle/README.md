# cljsjs/sizzle
[](dependency)
```clojure
[cljsjs/sizzle "2.3.0"] ;; latest release
```
[](/dependency)

ClojureScript package for [Sizzle](sizzle) - A pure-JavaScript CSS selector engine designed to be easily dropped in to a host library.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.sizzle))
```
[sizzle]: https://github.com/jquery/sizzle
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
