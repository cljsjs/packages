# cljsjs/react-toastify

https://github.com/fkhadra/react-toastify


[](dependency)
```clojure
[cljsjs/react-toastify "6.0.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-toastify))
   
  ;Example 
  [:> (aget js/ReactToastify "ToastContainer")]  

  [:button {:on-click #((aget js/ReactToastify "toast") "My Toast")} "Example"] 
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

For Styling embed css from https://unpkg.com/react-toastify@5.3.1/dist/ReactToastify.min.css or implement your own styles (Separated for custom styling)