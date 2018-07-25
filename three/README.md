# cljsjs/three

[](dependency)
```clojure
[cljsjs/three "0.0.91-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.three))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

#### Example: Simple spinning cube
```clojure
(ns minimal-cljs.core
  (:require cljsjs.three))

(defn init []

  ;;First initiate the basic elements of a THREE scene
  (let [scene    (js/THREE.Scene.)
        p-camera (js/THREE.PerspectiveCamera.
                    view-angle aspect near far)
        box      (js/THREE.BoxGeometry.
                    200 200 200)
        mat      (js/THREE.MeshBasicMaterial.
                    (js-obj "color" 0xff0000
                            "wireframe" true))
        mesh     (js/THREE.Mesh. box mat)
        renderer (js/THREE.WebGLRenderer.)]

    ;;Change the starting position of cube and camera
    (aset p-camera "name" "p-camera")
    (aset p-camera "position" "z" 500)
    (aset mesh "rotation" "x" 45)
    (aset mesh "rotation" "y" 0)
    (.setSize renderer 500 500)

    ;;Add camera, mesh and box to scene and then that to DOM node.
    (.add scene p-camera)
    (.add scene mesh)
    (.appendChild js/document.body (.-domElement renderer))

    ;Kick off the animation loop updating
    (defn render []
      (aset mesh "rotation" "y" (+ 0.01 (.-y (.-rotation mesh))))
      (.render renderer scene p-camera))

    (defn animate []
      (.requestAnimationFrame js/window animate)
      (render))

    (animate)))

(init)
```
