(ns cljsjs.packages.formatting)

;; Colors

(def c
  "Application colors"
  {:desc "#555"
   :org "#547cd0"
   :lib "#333"
   :ver "#528c2a"
   :clo "#bbb"
   :link "#1eaedb"})

;; Fonts

(def font-stack
  "Application fonts"
  (str "\"Raleway\", \"HelveticaNeue\", \"Helvetica Neue\", "
       "Helvetica, Arial, sans-serif"))

;; Styles

(def flex {:display "flex"})
(def flex-col {:flex-direction "column"})
(def flex-1 {:flex 1})

(def lib-view-div flex-1)
(def lib-view-h3 {:margin "4px 0 8px"})
(def lib-view-p {:color (c :desc) :font "13px sans-serif" :margin 0})

(def art-coords-pre {:margin "2px 0"})
(def art-coords-org {:color (c :org)})
(def art-coords-lib {:color (c :lib)})
(def art-coords-ver {:color (c :ver)})

(def art-clo-div {:padding-right "2px"})
(def art-clo-link {:font "0.75em sans-serif"
                   :text-decoration "none"
                   :color (c :clo)})

(def art-view-div
  (merge {:font-size "1.1em"
          :align-items "flex-end"
          :justify-content "center"}
         flex-1 flex flex-col))

(def no-pkgs {:margin "2em 0" :text-align "center"})
(def no-pkgs-em {:color (c :desc)})
(def no-pkgs-link {:color (c :link)})

(def pkgs-div {:width "100%"})
(def pkgs-div-div
  (merge {:border-top "1px solid #eee"
          :padding "8px 0"}
         flex))

(def search-input {:margin     "2em 0"
                   :padding    "0.25em"
                   :font-size  "1.1em"
                   :font-style "italic"})

(def view-container
  (merge {:min-width "640px"
          :align-items "center"
          :font-family font-stack}
         flex flex-col))
