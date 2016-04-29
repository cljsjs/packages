# cljsjs/moment

[](dependency)
```clojure
[cljsjs/moment "2.10.6-4"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.moment))
```

## Locales

Each locale from Moment.js is provided as separate foreign dependency namespace.
You should be able to set Moment to use locales if you first require them.

```clojure
(ns application.core
  (:require cljsjs.moment cljsjs.moment.locale.fi))

(.locale js/moment "fi")
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
