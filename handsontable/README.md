# cljsjs/handsontable

[](dependency)
```clojure
[cljsjs/handsontable "0.26.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.handsontable))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

#### Non-JS Dependencies
This package contains two CSS files, 

```css
/cljsjs/handsontable/development/handsontable.full.css      ;non-minified
/cljsjs/handsontable/production/handsontable.full.min.css   ;minified
```

     
One of which you must also load into your project in order to use Handsontable. 
Refer to [the wiki to learn how to include this file in your project](https://github.com/cljsjs/packages/wiki/Non-JS-Assets).
