# cljsjs/react-flexbox-grid

[](dependency)
```clojure
[cljsjs/react-flexbox-grid "1.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-flexbox-grid))
```

You also need to include the CSS. If you are using [sass4clj](https://github.com/Deraen/sass4clj) it'll look like this:

```scss
@import "cljsjs/react-flexbox-grid/development/react-flexbox-grid.inc";
```

for the development version of the CSS or

```scss
@import "cljsjs/react-flexbox-grid/production/react-flexbox-grid.min.inc";
```

for the production minified version.

You can use it like this:

```clojure
[:> (.-Grid js/ReactFlexboxGrid)
 [:> (.-Row js/ReactFlexboxGrid)
  [:> (.-Col js/ReactFlexboxGrid) {:xs 6 :md 3} "Hello World!"]]]
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
