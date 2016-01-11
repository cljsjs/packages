; For CI
(configure-repositories!
  (fn [{:keys [url] :as repo-map}]
    (->> (condp re-find url
           #"^https://clojars\.org/repo"
           {:username (get-sys-env "CLOJARS_USER" :required)
            :password (get-sys-env "CLOJARS_PASS" :required)}
           #".*" nil)
         (merge repo-map))))
