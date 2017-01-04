; For CI
(configure-repositories!
  (fn [{:keys [url] :as repo-map}]
    (->> (condp re-find url
           #"clojars"
           {:username (get-sys-env "CLOJARS_USER")
            :password (get-sys-env "CLOJARS_PASS")}
           #".*" nil)
         (merge repo-map))))
