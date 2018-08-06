# cljsjs/antd

[](dependency)
```clojure
[cljsjs/antd "3.7.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. after adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.antd]))
```
You would need to include the `antd` CSS file within your HTML file. The CSS files will be written to the following classpaths:

* `cljsjs/antd/development/antd.inc.css`
* `cljsjs/antd/production/antd.min.inc.css`

You can also follow instructions for customization with LESS [here](https://ant.design/docs/react/customize-theme).

As of `[cljsjs/antd "2.8.0-0"]`, the precompiled `antd` includes locales.
Locales are present under the global `antd` object, *e.g.*:

```clojure
(.. js/window.antd -locales -en_US)
```

If using `LocaleProvider`, pass the result of the above expression as the
`locale` prop.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
