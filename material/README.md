# cljsjs/material

[](dependency)
```clojure
[cljsjs/material "1.1.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require [cljsjs.material]))
```

You will want to include the material-icons from Google.  In Reacts, it would be done
by adding a component like so:

```clojure
[:link {:href "https://fonts.googleapis.com/icon?family=Material+Icons"
        :rel "stylesheet"}]
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
