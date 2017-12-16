# cljsjs/simplex-solver

[](dependency)
```clojure
[cljsjs/simplex-solver "0.0.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.simplex-solver))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Usage

If you include the `cljs.simplex-solver` namespace anywhere in your
ClojureScript code, simplex-solver will be available as the Javascript
global `js/simplex`.


```clojure
(.maximize js/simplex "x + y + 2z"  #js["2x + y + z <= 50"
                                        "2x + y >= 36"
                                        "x + z >= 11"])
```

For more information, see [github.com/SamDuvall/simplex-solver](https://github.com/SamDuvall/simplex-solver).
