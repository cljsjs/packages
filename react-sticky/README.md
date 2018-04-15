# cljsjs/react-sticky

[](dependency)
```clojure
[cljsjs/react-sticky "6.0.2-0"] ;; latest release
;; or bring your own React (>= 15.3)
[cljsjs/react-sticky "6.0.1-0" :exclusions [cljsjs/react cljsjs/react-dom]] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-sticky))
```

Calling react-sticky example

```clojure
(let [container (js/React.createElement js/ReactSticky.StickyContainer)
      sticky    (js/React.createElement js/ReactSticky.Sticky)]
  [container ...props...
    [sticky ...props...
      (fn [props]
        (reagent.core/as-element
          [:div {:style (aget props "style")}
            ...]))]])
```

`<Sticky>` expects a function as its only child, and that function must return a valid React component. The above example shows how to achieve this with an anonymous function returning the value from `reagent.core/as-element`.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Generating externs

Externs for this package were generated with [`javascript-externs-generator`](https://github.com/jmmk/javascript-externs-generator):

First build a package to get access to `react-sticky.inc.js`:

```shell
boot package target
```

Then download the peer dependencies of react-sticky (as specified in `package.json`):

```shell
curl -L -o target/react-with-addons.js https://cdnjs.cloudflare.com/ajax/libs/react/15.3.1/react-with-addons.js
curl -L -o target/react-dom.js https://cdnjs.cloudflare.com/ajax/libs/react/15.3.1/react-dom.js
```

Then using the `generate-extern` cli utility externs can be generated:

```shell
generate-extern -f target/react-with-addons.js,target/react-dom.js,target/cljsjs/react-sticky/development/react-sticky.inc.js -n ReactSticky -o resources/cljsjs/react-sticky/common/react-sticky.ext.js
```
