# cljsjs/chosen

This is a cljsjs package for https://github.com/harvesthq/chosen

[](dependency)
```clojure
[cljsjs/chosen "1.4.2-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.chosen))
```
[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

# CSS Assets

This jar comes with additional CSS assets:

* chosen.css
* chosen.min.css
* chosen-sprite.png
* chosen-sprite@2x.png

They can be referenced as follows:

```clojure
;; If you need direct file access
(clojure.java.io/resource "public/chosen/css/chosen.css")

;; If you're using compojure for routing, by default it will serve
;; assets under "/public".  This means GET /assets/chosen/css/chosen.css
;; will work as expected if you add the following handler:
(compojure.route/resources "/assets")

;; If you're using hiccup
(hiccup.page/include-css "assets/chosen/css/chosen.css")
```
