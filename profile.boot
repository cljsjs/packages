; For CI
(configure-repositories!
  (fn [{:keys [url] :as repo-map}]
    (->> (condp re-find url
           #"^https://repo\.clojars\.org"
           {:username (get-sys-env "CLOJARS_USER")
            :password (get-sys-env "CLOJARS_PASS")}
           #".*" nil)
         (merge repo-map))))
