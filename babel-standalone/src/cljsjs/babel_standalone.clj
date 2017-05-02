(ns cljsjs.babel-standalone
  "Provides cljs.closure/js-transforms :cljsjs/babel preprocess implementation.

  Babel options (http://babeljs.io/docs/usage/api/#options) can be configured
  using :cljsjs/babel-opts property on the foreign lib maps."
  (:require [clojure.java.io :as io]
            [cljs.build.api :as b]
            [cljs.closure :as closure]
            [clojure.data.json :as json])
  (:import javax.script.ScriptEngineManager))

;;
;; Low level API
;;

(defn create-engine
  "Returns a nashorn engine with Babel-standalone loaded."
  []
  (doto (.getEngineByName (ScriptEngineManager.) "nashorn")
    (.eval (io/reader (io/resource "cljsjs/babel-standalone/production/babel.min.js")))))

(defn process
  "Given JavaScript source and babel options, return the processed source."
  [engine source babel-opts]
  (let [babel-opts-json (json/write-str (merge {:presets ["react" "es2016"]}
                                               babel-opts))
        code-var (str (gensym))]
    (.put engine code-var source)
    (.eval engine (str "Babel.transform("code-var", "babel-opts-json").code"))))

;;
;; Default js-transforms implementation
;;

(defonce ^:private default-engine (delay (create-engine)))

(defmethod closure/js-transforms :cljsjs.babel-standalone/babel [ijs opts]
  (let [babel-opts (merge {:presets ["react" "es2016"]}
                          (:cljsjs.babel-standalone/babel-opts ijs))]
    (assoc ijs :source (process @default-engine (:source ijs) babel-opts))))

;;
;; Test
;;

(comment
  (closure/js-transforms {:source "export var reactHello = function() { return <div>Hello world</div> };"
                          :preprocess :cljsjs/babel
                          :cljsjs/babel-opts {:presets ["react" "es2016"]}
                          :module-type :es6}
                         {}))
