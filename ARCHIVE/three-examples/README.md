# cljsjs/three-examples

Three.js packages a variety of useful utilities and scripts in an "examples" directory. This package enables use of them in CLJS easily.

[](dependency)
```clojure
[cljsjs/three-examples "0.0.91-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler.

As these scripts total a large amount of javascript, they have been kept in separate files and assigned separate namespaces, allowing only import and use of the desired scripts.

Currently an automated processing of the files from the `examples/js` directory. Namespaces follow the directory layout, with the following namespace following the script's filename. Some scripts require other scripts, and the documentation needs to be consulted.

```clojure
(ns application.core
  (:require [cljsjs.three-examples.loaders.MTLLoader]
      [cljsjs.three-examples.loaders.OBJLoader2])) ;OBJLoader2 depends on MTL loader for `loadMtl`
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

#### Example: Simple spinning cube
```clojure
(ns minimal-cljs.core
  (:require [cljsjs.three]
            [cljsjs.three-examples.loaders.MTLLoader]
            [cljsjs.three-examples.loaders.OBJLoader2]))

(defn init []

  ;;First initiate the basic elements of a THREE scene
  (let [scene    (js/THREE.Scene.)
        p-camera (js/THREE.PerspectiveCamera.
                  75 1 0.1 1000)
        light (js/THREE.AmbientLight. 0xffffff)
        obj-loader (js/THREE.OBJLoader2.)
        mtl-loader (js/THREE.MTLLoader.)
        pivot    (js/THREE.Object3D.)
        renderer (js/THREE.WebGLRenderer.)]

    ;;Change the starting position of cube and camera
    (aset p-camera "name" "p-camera")
    (aset p-camera "position" "z" 300)
    (aset pivot "rotation" "x" 45)
    (aset pivot "rotation" "y" 0)
    (.setSize renderer 500 500)

    ;;Add camera, pivot and box to scene and then that to DOM node.
    (.add scene p-camera)
    (.add scene pivot)
    (.add scene light)
    (.appendChild js/document.body (.-domElement renderer))

    ;;Load OBJ and MTL file
    (.setPath mtl-loader "https://raw.githubusercontent.com/mrdoob/three.js/dev/examples/obj/male02/")
    (.setCrossOrigin mtl-loader "anonymous")
    (.load mtl-loader "male02.mtl"
           (fn [materials]
             (.setSceneGraphBaseNode obj-loader pivot)
             (.preload materials)
             (.setMaterials obj-loader (aget materials "materials"))
             (.setPath obj-loader "https://raw.githubusercontent.com/mrdoob/three.js/dev/examples/obj/male02/")
             (.load obj-loader "male02.obj"
                    (fn [event]
                      (println "Obj model loaded")))))

    ;Kick off the animation loop updating
    (defn render []
      (aset pivot "rotation" "y" (+ 0.01 (.-y (.-rotation pivot))))
      (.render renderer scene p-camera))

    (defn animate []
      (.requestAnimationFrame js/window animate)
      (render))

    (animate)))

(init)
```
