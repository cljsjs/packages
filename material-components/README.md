# cljsjs/material-components - Material Design Components for the web

[](dependency)
```clojure
[cljsjs/material-components "0.34.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require [cljsjs.material-components]))
```

## Theming
Because this is largely about design, we would be remiss if we were to
offer this without some ability to change the theme.
Following [Non-JS Assets][nonjs] for SASS, you need to set up sass4clj or
another sass compiler to include the files into your compiled css. Create a SCSS
file and include the components from the jar that you need:

```sass
@import "cljsjs/material-components/development/material-components.inc";

$mdc-theme-primary: #9c27b0;
$mdc-theme-accent: #ffab40;
$mdc-theme-background: #fff;

@import "cljsjs/material-components/development/packages/mdc-theme/mdc-theme";
```

Here, I import the base css for all the material components, then I set my theme
according to the [MDC Theme Package][mdctheme]. There are many more options for
mixins if you so desire. You would then load the compiled css in your project.
Et voilà, you are set free to theme away.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[nonjs]: https://github.com/cljsjs/packages/wiki/Non-JS-Assets
[mdctheme]: https://github.com/material-components/material-components-web/tree/master/packages/mdc-theme
