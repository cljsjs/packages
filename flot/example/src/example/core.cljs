(ns example.core
  (:require
    cljsjs.flot
    cljsjs.flot.plugins.crosshair))

(def $ js/$)

(defn main []
  (let [version-str (str "Flot " (.. $ -plot -version) " &ndash; ")
        steps (range 0 14 0.1)
        sin (for [i steps] [i (.sin js/Math i)])
        cos (for [i steps] [i (.cos js/Math i)])
        plot (.plot $ "#placeholder"
                    (clj->js [{:data sin :label "sin(x) = -0.00"}
                              {:data cos :label "cos(x) = -0.00"}])
                    (clj->js {:series {:lines {:show true}}
                              :crosshair {:mode "x"}
                              :grid {:hoverable true
                                     :autoHighlight false}
                              :yaxis {:min -1.2 :max 1.2}}))]

    ;; making sure we can call functions on plot
    (.log js/console (.getAxes plot))
    (.log js/console (.getData plot))
    (-> ($ "#footer") (.prepend version-str))))

(enable-console-print!)

(println "Hello world!")

($ main)
