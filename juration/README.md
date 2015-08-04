# cljsjs/juration

A cljs interface to [juration](https://github.com/domchristie/juration) - A simple natural language duration parser written in javascript.

[](dependency)
```clojure
[cljsjs/juration "0.0.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.juration))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

Note: This extern pulls directly from a commit for 0.0.1 as there are no released downloads. If you know of one please submit a PR.

## Example usage

```clojure
(.parse js/juration "45m")
```

```clojure
(.stringify js/juration 2000))
```
