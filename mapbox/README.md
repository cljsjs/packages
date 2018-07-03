# cljsjs/mapbox

[](dependency)
```clojure
[cljsjs/mapbox "0.46.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. after adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.mapbox]))
```
You would need to include the `mapbox-gl` CSS file within your HTML file. The CSS files will be written to the following classpaths:

* `cljsjs/mapbox/development/mapbox-gl-dev.inc.css`
* `cljsjs/mapbox/production/mapbox-gl.inc.css`

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
