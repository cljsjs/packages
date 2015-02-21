(ns cljsjs.packages.app
  (:require-macros [cljsjs.packages.data :as data])
  (:require [cljs.reader                 :as reader]
            [clojure.string              :as s]
            [reagent.core                :as r]
            [cljsjs.packages.formatting  :as css :refer [c font-stack]]))

;; Data

(def packages
  (->> (data/packages-data)
    reader/read-string
    (sort-by :artifact)))

(def contributing-package-link
  "https://github.com/cljsjs/packages/wiki/Creating-a-CLJSJS-package")

;; Helpers

(defn filter-packages-by [string]
  (filter
   (fn [{:keys [artifact description]}]
     (let [match (str artifact " " description)]
       (not (neg? (.indexOf (s/lower-case match)
                            (s/lower-case (s/trim string)))))))
   packages))

(defn inside-iframe? []
  (try
    (not (= (.-self js/window) (.-top js/window)))
    (catch js/Object _
      true)))

;; Views

(defn lib-view [lib-name description]
  [:div {:style css/lib-view-div}
   [:h3 {:style css/lib-view-h3} lib-name]
   [:p {:style css/lib-view-p} description]])

(defn- clojars [org-name lib-name]
  (str "clojars.org/" org-name "/" lib-name))

(defn artifact-coords-view [org-name lib-name version]
  [:div
   [:pre {:style css/art-coords-pre} "["
    [:span {:style css/art-coords-org} org-name] "/"
    [:span {:style css/art-coords-lib} lib-name] " "
    [:span {:style css/art-coords-ver} (str "\"" version "\"")] "]"]])

(defn artifact-clojars-view [org-name lib-name]
  (let [link (clojars org-name lib-name)]
    [:div {:style css/art-clo-div}
     [:a {:style  css/art-clo-link
          :href   (str "https://" link)
          :target "_blank"}
      link]]))

(defn artifact-view [org-name lib-name version]
  [:div {:style css/art-view-div}
   [artifact-coords-view org-name lib-name version]
   [artifact-clojars-view org-name lib-name]])

(defn no-packages-found-view []
  [:div {:style css/no-pkgs}
   [:p
    [:em {:style css/no-pkgs-em}
     "Couldn't find any packages. "]]
   [:p
    [:a {:style css/no-pkgs-link
         :href contributing-package-link}
     "Learn how to create a package."]]])

(defn packages-view [packages']
  [:div {:style css/pkgs-div}
   (if-let [packages (not-empty @packages')]
     (for [{:keys [artifact version description]} packages]
       (let [[org-name lib-name] (s/split artifact #"/")]
         ^{:key artifact}
         [:div {:style css/pkgs-div-div}
          [lib-view lib-name description]
          [artifact-view org-name lib-name version]]))
     [no-packages-found-view])])

(defn search-view [packages']
  [:input
   {:style css/search-input
    :type "search", :placeholder "Filter packages...", :autofocus true
    :on-change
    (fn [e]
      (reset! packages' (filter-packages-by (.-value (.-target e)))))}])

(defn view [packages]
  (let [packages' (r/atom packages)]
    (fn [_]
      [:div.cljsjs-packages-container
       {:style css/view-container}
       (when (not (inside-iframe?))
         [:h1 "CLJSJS Packages"])
       [search-view packages']
       [packages-view packages']])))

;; Entrypoint (see conf/main.cljs.edn)

(defn init []
  (let [root (.getElementById js/document "root")]
    (r/render [view packages] root)))
