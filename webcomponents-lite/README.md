# cljsjs/webcomponents-lite

[](dependency)
```clojure
[cljsjs/webcomponents-lite "0.7.14-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.webcomponents-lite))
```

`webcomponents-lite` A suite of polyfills supporting the HTML Web Components specs. (without shadow-dom)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
