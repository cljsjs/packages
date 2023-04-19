# cljsjs/ant-design-pro

[](dependency)
```clojure
[cljsjs/ant-design-pro "2.1.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. after adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.ant-design-pro]))

(def antdpro js/AntDesignPro)
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [ant-design-pro]))

(def antdpro js/AntDesignPro)
```

You would need to include the `ant-design-pro` CSS file within your HTML file. The CSS files will be written to the following classpaths:

* `cljsjs/ant-design-pro/development/ant-design-pro.inc.css`
* `cljsjs/ant-design-pro/production/ant-design-pro.min.inc.css`

You can also follow instructions for customization with LESS [here](https://ant.design/docs/react/customize-theme).

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
