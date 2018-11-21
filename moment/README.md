# cljsjs/moment

[](dependency)
```clojure
[cljsjs/moment "2.22.2-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.moment))

(console.log (.format (js/moment)))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [moment :as moment]))

(console.log (.format (moment.)))
```

## Locales

Each locale from Moment.js is provided as separate foreign dependency namespace.
You should be able to set Moment to use locales if you first require them.

```clojure
(ns application.core
  (:require cljsjs.moment cljsjs.moment.locale.fi))

(.locale js/moment "fi")
```

You can also use the following syntax:

```clojure
(ns application.core
  (:require [moment :as moment]
            [moment.locale.fi]))

(.locale moment "fi")
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
