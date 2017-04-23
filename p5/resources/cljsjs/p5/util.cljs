(ns cljsjs.p5.util
  (:require [clojure.string :as str]
            [cljsjs.p5])
)

(def ^:dynamic *current-sketch* nil)

(defn get-sketch [] *current-sketch*)

(defn with-sketch [obj func]
  (fn []
    (this-as this
      (binding [*current-sketch* obj] (func))))
)

(defn apply-to-sketch [fun & args]
  (let [sketch (get-sketch)
        f (aget sketch fun)]
    (.apply f sketch (clj->js args))
    )
)


(defn resolve-constant [key]
  (aget js/p5.prototype (str/upper-case (name key)))
)

(defn frame-rate [num]
  (.frameRate (get-sketch) num)
)

(defn pixel-density []
  (.pixelDensity (get-sketch))
)

(defn push-matrix []
  (.push (get-sketch))
)

(defn pop-matrix []
  (.pop (get-sketch))
)

(defn millis []
  (.millis (get-sketch))
)

(defn no-fill []
  (.noFill (get-sketch))
)

(defn no-stroke []
  (.noStroke (get-sketch))
)

(defn clear []
  (.clear (get-sketch))
)

(defn stroke [& args]
  (apply-to-sketch "stroke" args)
)

(defn fill [& args]
  (apply-to-sketch "fill" args)
)

(defn background [& args]
  (apply-to-sketch "background" args)
)

(defn translate [x y]
  (.translate (get-sketch) x y)
)

(defn rotate [angle]
  (.rotate (get-sketch) angle)
)

(defn create-canvas [width height]
  (.createCanvas (get-sketch) width height)
)

(defn rect-mode [mode]
  (.rectMode (get-sketch) (resolve-constant mode))
)

(defn color-mode [mode]
  (.colorMode (get-sketch) (resolve-constant mode))
)

(defn create-sketch [options]
  (let [p  (js/p5. (fn [obj]
                     (aset obj "setup" (with-sketch obj (:setup options)))
                     (aset obj "draw"  (with-sketch obj (:draw options)))
                     ) (:element-id options))]
    p                 
    )
)

(defn curve-vertex [x y] 
  (.curveVertex (get-sketch) x y))

(defn stroke-weight [weight]
  (.strokeWeight (get-sketch) weight)
)

(defn rect [x y w h] 
  (.rect (get-sketch) x y w h))

(defn ellipse [x y w h] 
  (.ellipse (get-sketch) x y w h))

