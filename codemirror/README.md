# cljsjs/codemirror

[](dependency)
```clojure
[cljsjs/codemirror "5.1.0-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.codemirror))
```

You can add the following boot tasks to add the css to your project.

```
    (sift :add-jar {'cljsjs/codemirror #"cljsjs/codemirror/common/codemirror.css"})
    (sift :move {#"cljsjs/codemirror/common/codemirror.css" "vendor/codemirror/codemirror.css"})))
```

You can know use ```js/CodeMirror```. See [this project](https://github.com/Jonovono/CodeMirror-cljs/blob/master/src/cljs/codemirror_cljs/core.cljs) for examples of wrapping the ```js/CodeMirror``` javascript object with ClojureScript functions.

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

Thanks to @urmuzov for the [extern file](https://raw.githubusercontent.com/urmuzov/closure-externs/master/codemirror.js)