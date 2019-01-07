# cljsjs/react-datetime

[](dependency)
```clojure
[cljsjs/react-datetime "2.16.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-datetime))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Usage

If you include the `cljs.react-datetime` namespace anywhere in your
ClojureScript code, react-datetime will be available as the Javascript
global `js/Datetime`.

For use in reagent code, you need to wrap the Datetime component using
`adapt-react-class`:

```clojure
(ns my.reagent.app
  (:require [reagent.core :as r]))

(defonce !state (r/atom nil))
(def datetime (r/adapt-react-class js/Datetime))

(defn my-component []
   [datetime {:value @!state
              :on-change #(reset! !state (.toDate %))}])
```

For more information, see the project's [official docs](https://github.com/YouCanBookMe/react-datetime).
