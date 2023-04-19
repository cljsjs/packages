# cljsjs/bootstrap-typeahead

[](dependency)
```clojure
[cljsjs/bootstrap-typeahead "4.0.2-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.bootstrap-typeahead))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Example:

### index.html
```html
<html>
    <head>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
      <div class="container">
        <form>
          <div class="form-group">
            <label for="example">Animals</label>
            <input id="example" class="typeahead form-control" type="text" data-provide="typeahead" autocomplete="off" placeholder="Animals">
          </div>
        </form>
      </div>
      <script src="out/typeahead_example.js" type="text/javascript"></script>
    </body>
</html>
```

### core.cljs
```clojure
(ns typeahead-example.core
  (:require [clojure.browser.repl :as repl]
            [cljsjs.bootstrap-typeahead]))

(def animals
  ["dog"
   "dolphin"
   "cat"
   "crow"
   "mouse"
   "marmoset"])

(doto
  (js/$ ".typeahead")
  (.typeahead (clj->js {:name ""
                        :source animals})))
```
