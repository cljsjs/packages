# cljsjs/web-animations

[](dependency)
```clojure
[cljsjs/web-animations "2.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.web-animations))
```

`web-animations` polyfills Web Animations [W3C spec](http://w3c.github.io/web-animations/).

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
