(ns cljsjs.packages.data
  (:require [clojure.java.io :as io]
            [clojure.walk    :as walk]
            [clojure.edn     :as edn]))


;; Collecting package builds

(def app-dir
  "App directory name, whose `build.boot` will be ignored. All
  others will be considered those of CLJSJS package builds."
  (let [file-name "config.edn"
        config    (io/resource file-name)]
    (assert config (str "Could not find config: " file-name))
    (-> config slurp edn/read-string :app-dir)))

(defn- app-dir?        [f] (.contains (str f) app-dir))
(defn- build-dot-boot? [f] (.endsWith (str f) "build.boot"))

(defn find-all-builds
  "Returns all package `build.boot` files. Assumes their directories
  are siblings to the current app's directory."
  []
  (->> "../" io/file file-seq
    (filter build-dot-boot?)
    (remove app-dir?)))


;; Reading

(defn- read-one [r]
  (try (read r)
       (catch java.lang.RuntimeException e
         (if (= "EOF while reading" (.getMessage e)) ::EOF
           (throw e)))))

(defn read-seq-from-file
  "Reads a sequence of top-level objects in file."
  [file]
  (with-open [r (java.io.PushbackReader. (io/reader file))]
    (binding [*read-eval* false]
      (doall (take-while #(not= ::EOF %) (repeatedly #(read-one r)))))))


;; Extracting and formatting data

(defn- version-form?      [form] (= '(def +version+) (take 2 form)))
(defn- task-options-form? [form] (= 'task-options!   (first form)))

(defn get-version [forms]
  (->> forms
    (filter version-form?)
    first
    last))

(defn get-poms [forms]
  (->> forms
    (filter task-options-form?)
    (map last)))

(defn- get-artifact-name [pom] (second (:project pom)))
(defn- get-description   [pom] (:description pom))

(defn pom-mapper-for
  "Returns a closure that generates the artifact's pom map with
  :artifact, :version and :description keys, using the version already
  found in its respective `build.boot`."
  [version]
  (fn [pom]
    {:artifact    (str (get-artifact-name pom))
     :version     version
     :description (get-description pom)}))

(defn unroll
  "Returns a sequence of all sexps of any depth from an initial sequence of forms"
  [forms]
  (filter coll? (rest (tree-seq sequential? seq forms))))

(defn build->packages
  "Converts a `build.boot` file into one or more package artifact maps.

  Assumes there will be just one top-level (def +version+ \"...\") form
  but that there may be (task-options! ...) forms with artifact names
  and descriptions at any level."
  [file]
  (let [forms   (read-seq-from-file file)
        version (get-version forms)
        poms    (get-poms (unroll forms))]
    (mapv (pom-mapper-for version) poms)))


;; ClojureScript API

(defmacro packages-data []
  (let [builds (find-all-builds)
        data   (flatten (mapv build->packages builds))]
    (pr-str data)))
