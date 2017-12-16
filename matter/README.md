# cljsjs/matter

[](dependency)
```clojure
[cljsjs/matter "0.12.0-14"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.matter))
```

Documentation for the matter.js lib can be found [on its github page](https://github.com/liabru/matter-js)

I made updates to the externs by regenerating them using [Javascript Externs Generator](https://github.com/jmmk/javascript-externs-generator), merging the files using with a diff tool, and then creating a list of all the properties that weren't included using:

```bash
 egrep "^var.*{};|@property .*" m
 ```

Followed by a lot of manual editing and merging. The examples I've tried work with advanced optimisations, but there still may be things missed.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
