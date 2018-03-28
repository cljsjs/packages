# cljsjs/simplemde

[](dependency)
```clojure
[cljsjs/simplemde "1.11.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.simplemde))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

#### Non-JS Dependencies
This package contains two CSS files,

```css
/cljsjs/simplemde/development/simplemde.css      ;non-minified
/cljsjs/simplemde/production/simplemde.min.css   ;minified
```


One of which you must also load into your project in order to use SimpleMDE.
Refer to [the wiki to learn how to include this file in your project](https://github.com/cljsjs/packages/wiki/Non-JS-Assets).
