# cljsjs/react-leaflet

[](dependency)
```clojure
[cljsjs/react-leaflet "0.11.4-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-leaflet))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

Note: This extern is a work in progress. You may need to add symbols
as needed. For example (from leaflet library):

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
