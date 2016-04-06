# cljsjs/pikaday

[](dependency)
```clojure
[cljsjs/pikaday "1.4.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pikaday))
```

or if you want to use pikadays optional Moment.js integration:

```clojure
(ns application.core
  (:require cljsjs.pikaday.with-moment))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
