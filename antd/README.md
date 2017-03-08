# cljsjs/antd

[](dependency)
```clojure
[cljsjs/antd "2.8.0-0"] ;; latest release
```
[](/dependency)


This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. after adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.antd]))
```

This package **does not include antd's CSS!** You can include a precompiled
version of the CSS via [CDN](https://cdnjs.com/libraries/antd), or you can
follow instructions for customization with
LESS [here](https://ant.design/docs/react/customize-theme).

As of `[cljsjs/antd "2.8.0-0"]`, the precompiled `antd` includes locales.
Locales are present under the global `antd` object, *e.g.*:

```clojure
(.. js/window.antd -locales -en_US)
```

If using `LocaleProvider`, pass the result of the above expression as the
`locale` prop.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
