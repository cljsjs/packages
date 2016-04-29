# cljsjs/react-bootstrap

[](dependency)
```clojure
[cljsjs/react-bootstrap "0.29.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-bootstrap))
```

To use this with Boot require "boot-less" like so:
```clojure
(set-env!
  :dependencies '[[deraen/boot-less "0.3.0" :scope "test"]
                  [cljsjs/react-bootstrap "0.28.1-0"]])

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

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
