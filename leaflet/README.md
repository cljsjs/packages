# cljsjs/leaflet

[](dependency)
```clojure
[cljsjs/leaflet "1.9.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.leaflet))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## News

**Version 1.1.0-0** moves the files under `cljsjs/leaflet` prefix,
so you might need to update CSS requires etc.

## Notes

Note: This extern is a work in progress. You may need to add symbols
as needed. For example:

```clojure
(.setView (.map js/L "map") #js [lat lng] 10)
```

was throwing the following error:

```bash
Uncaught TypeError: L.map(...).Zc is not a function
```

The solution was to edit leaflet.ext.js and change this:

```javascript
"map": function () {},
```

To this:

```javascript
"map": {
  "setView": function () {},
},
```
