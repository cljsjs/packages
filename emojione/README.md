# cljsjs/emojione


[](dependency)
```clojure
[cljsjs/emojione "2.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.emojione))
```

Documentation for Emojione can be found [in their GitHub repo](https://github.com/Ranks/emojione).

#### Assets

All contents of the `assets/` folder in the EmojiOne release zip are
provided under `cljsjs/emojione/common/`. Because these assets are big
(50mb) make sure this jar is cached in CI to avoid re-downloading it
all the time.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
