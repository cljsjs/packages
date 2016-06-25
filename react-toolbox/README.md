# cljsjs/react-toolbox

```clojure
[cljsjs/react "1.0.1-1"] ;; latest release
```

[React Toolbox](http://react-toolbox.com/)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns my-ap.core
  (:require [cljsjs.react-toolbox]))

(def react-toolbox js/ReactToolbox)
```

Note that react-toolbox is designed to work hand-in-hand with webpack and Sass.
This is quite cumbersome to setup with cljs, so cljsljs/react-toolbox publishes
each react-toolbox component in the bundled form (styles included). To override
component styles, take a look at [react-css-themr](https://github.com/javivelasco/react-css-themr).

React, ReactDOM, and ReactAddonsCssTransitionGroup are the dependencies for
react-toolbox. This cljsjs/react-toolbox supports loading these libraries via
commonjs, commonjs2, or plain old `window.{dependency}`. Take a look at the webpack
config inside `/resources` for more details.
