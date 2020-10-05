# cljsjs/react-bootstrap

[](dependency)
```clojure
[cljsjs/react-bootstrap "1.3.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-bootstrap))
```

To use this with Boot, require [boot-less][less4clj] like so:
```clojure
(set-env!
  :dependencies '[[deraen/boot-less "0.6.2" :scope "test"]
                  [cljsjs/react-bootstrap "1.0.0-beta.14-0"]])

```
create a "main.main.less" file within one of your source-paths with following content
```css
@import "bootstrap/less/bootstrap";
```
and include the compiled "main.css" in your "index.html",
then compile your cljs project e.g:
```sh
boot cljs less
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[less4clj]: https://github.com/Deraen/less4clj
