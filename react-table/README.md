# cljsjs/react-table

[](dependency)
```clojure
[cljsjs/react-table "6.8.6-0"] ;; latest release
```
[](/dependency)


```clojure
(ns application.core
  (:require cljsjs.react-table))
```

## Usage

If you include the `cljs.react-table` namespace anywhere in your
ClojureScript code, react-table will be available as the Javascript
global `js/ReactTable`.

For use in reagent code, you need to wrap the ReactTable component using
`adapt-react-class`:

```clojure
(ns my.reagent.app
  (:require [reagent.core :as r]))

(def ReactTable (r/adapt-react-class (aget js/ReactTable "default")))

(defn my-component []
  [ReactTable {:data [] :columns []}])
```

For more information, see the project's [official docs](https://react-table.js.org/).
