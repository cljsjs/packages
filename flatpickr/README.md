# cljsjs/flatpickr

[](dependency)
```clojure
[cljsjs/flatpickr "3.1.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.flatpickr))
```

## Assets

The jar includes the stylesheets from the flatpickr distribution.

```
flatpickr.css
flatpickr.min.css
ie.css
plugins
└── confirmDate
    └── confirmDate.css
rtl
├── flatpickr.min.css
└── themes
    ├── airbnb.rtl.css
    ├── base16_flat.rtl.css
    ├── confetti.rtl.css
    ├── dark.rtl.css
    ├── material_blue.rtl.css
    ├── material_green.rtl.css
    ├── material_orange.rtl.css
    └── material_red.rtl.css
themes
├── airbnb.css
├── confetti.css
├── dark.css
├── light.css
├── material_blue.css
├── material_green.css
├── material_orange.css
└── material_red.css
 ```

These end up in `public/flatpickr/`. So, if you are already serving assets from `public/` you should be able to reference them from your html like so:

```html
<link rel="stylesheet" href="/flatpickr/flatpickr.min.css">
```


## Plugins and i10n

Plugins and locales are not yet supported.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
