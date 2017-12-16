# cljsjs/emojione


[](dependency)
```clojure
[cljsjs/emojione "2.2.6-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.emojione))
```

Documentation for Emojione can be found [in their GitHub repo](https://github.com/Ranks/emojione).

#### Assets

All contents except `fonts` and `png_512x512` of the `assets/` folder
in the EmojiOne release zip are provided under
`cljsjs/emojione/common/`.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
