# cljsjs/mathbox

[](dependency)
```clojure
[cljsjs/mathbox "0.0.1-0"] ;; latest release
```
[](/dependency)

ClojureScript package for the [MathBox](mathbox) mathematical visualization library. Note that this is MathBox 1, not the very different [MathBox 2](mathbox2) library by the same author, which is in alpha release as of this writing. Author is also preparing a cljs-mathbox library for Clojars, which is an idiomatic(ish) cljs wrapper for MathBox.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.mathbox))
```

[mathbox]: https://github.com/unconed/MathBox.js/tree/legacy
[mathbox2]: https://gitgud.io/unconed/mathbox
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
