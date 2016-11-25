# cljsjs/flatpickr

[](dependency)
```clojure
[cljsjs/flatpickr "2.0.0-rc.7-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.flatpickr))
```

## Assets

The jar includes the stylesheets from the flatpickr distribution.

* flatpickr.base16_flat.min.css
* flatpickr.confetti.min.css
* flatpickr.dark.min.css
* flatpickr.grapefruit.min.css
* flatpickr.material_blue.min.css
* flatpickr.material_green.min.css
* flatpickr.material_orange.min.css
* flatpickr.material_red.min.css
* flatpickr.min.css

These end up in `public/flatpickr/`. So, if you are already serving assets from `public/` you should be able to reference them from your html like so:

```html
<link rel="stylesheet" href="/flatpickr/flatpickr.min.css">
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
