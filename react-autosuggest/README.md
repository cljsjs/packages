# cljsjs/react-autosuggest

[](dependency)
```clojure
[cljsjs/react-autosuggest "3.5.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-autosuggest))
```

A sample reagent project that uses the library is available at [https://github.com/cdorrat/autosuggest-sample](https://github.com/cdorrat/autosuggest-sample)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
