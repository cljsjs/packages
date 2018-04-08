# cljsjs/react-color

[](dependency)
```clojure
[cljsjs/react-color "2.13.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-color))
```

## Color Pickers

`react-color` provides color picker components for React and as such is usable from any Clojurescript
React-based library.

The following is an example of providing factory functions for each of the color pickers.

```clojure
(ns yourproj.color-pickers
  (:require [cljsjs.react]
            [cljsjs.react-color]))

(def alpha-picker (js/React.createFactory js/ReactColor.AlphaPicker))
(def block-picker (js/React.createFactory js/ReactColor.BlockPicker))
(def chrome-picker (js/React.createFactory js/ReactColor.ChromePicker))
(def circle-picker (js/React.createFactory js/ReactColor.CirclePicker))
(def compact-picker (js/React.createFactory js/ReactColor.CompactPicker))
(def github-picker (js/React.createFactory js/ReactColor.GithubPicker))
(def hue-picker (js/React.createFactory js/ReactColor.HuePicker))
(def material-picker (js/React.createFactory js/ReactColor.MaterialPicker))
(def photoshop-picker (js/React.createFactory js/ReactColor.PhotoshopPicker))
(def sketch-picker (js/React.createFactory js/ReactColor.SketchPicker))
(def slider-picker (js/React.createFactory js/ReactColor.SliderPicker))
(def swatches-picker (js/React.createFactory js/ReactColor.SwatchesPicker))
(def twitter-picker (js/React.createFactory js/ReactColor.TwitterPicker))
(def custom-picker (js/React.createFactory js/ReactColor.CustomPicker))

```

Example usage of chrome color picker:

```clojure
(ns yourproj.core
   (:require [yourproj.color-pickers :as color-pickers]))
...
   (color-pickers/chrome-picker
       #js {:color "#2CCCE4"
            :onChangeComplete (fn [color event] (println "color: " color)})
```

See the Javascript [documentation](http://casesandberg.github.io/react-color/) for more details.

## Maintenance

Update the version number in build.boot and README.md.

The build.boot will download the matching source from the github archive, bundle using webpack then  minify the js file.

The react-colors.ext.js file was manually created, and has one entry for each exported ColorPicker React component.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
