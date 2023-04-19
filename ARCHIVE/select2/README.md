# cljsjs/select2

[](dependency)
```clojure
[cljsjs/select2 "4.0.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.select2]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Example:

### index.html

```html
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="resources/select2.css">
    </head>
    <body>
      <div class="container">
        <select class="js-states form-control">
          <optgroup label="Alaskan/Hawaiian Time Zone">
            <option value="AK">Alaska</option>
            <option value="HI">Hawaii</option>
          </optgroup>
          <optgroup label="Pacific Time Zone">
            <option value="CA">California</option>
            ...
          </optgroup>
        </select>

      </div>
      <script src="out/select2_example.js" type="text/javascript"></script>
    </body>
</html>
```

### select2_example.cljs

```clojure
(ns select2-example.core
  (:require [cljsjs.select2]))

(.select2 (js/$ ".js-states"))
```
