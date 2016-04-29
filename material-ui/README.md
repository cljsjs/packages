# cljsjs/material-ui

http://www.material-ui.com/#/

[](dependency)
```clojure
[cljsjs/material-ui "0.15.0-beta.2-10"] ;; latest release
```
[](/dependency)

#### Important note
`cljsjs/material-ui` comes with its own `cljsjs/react` and `cljsjs/react.dom`. This is because it currently has to 
 be built with [react-tap-event-plugin](https://github.com/zilverline/react-tap-event-plugin). Read more [here](http://www.material-ui.com/v0.15.0-beta.2/#/get-started/installation). This won't be needed in a future.
 Important is to put `react` and `react.dom` into `exclusions` in `project.clj` for libraries, which include it.
 For example:
  
 ```
    [org.omcljs/om "1.0.0-alpha34" :exclusions [cljsjs/react cljsjs/react-dom]]
 ```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.material-ui
                  cljsjs.material-ui-svg-icons))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
