# cljsjs/react-relay

[](dependency)
```clojure
[cljsjs/react-relay "0.7.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-relay))
```

## Usage

Because JavaScript lacks macros, Relay currently depends on [Babel](babel) to compile `Relay.QL` query strings.
Because ClojureScript has macros, we can use them to shell out to Node, like this:

```clojure
(ns my.project.relay ; .clj macro file
  (:require
   [clojure.java.io :as io]
   [me.raynes.conch :as conch]))

(defn ^:private ql* [env query]
  (let [filename (-> env :ns :name)
        {:keys [line column]} env
        code (str  "/* " filename " " line " " column "*/" ; unique key for every query
                   "Relay.QL`" query "`")
        schema (-> "relay/schema.json" io/resource slurp) ; GraphQL schema from introspection query
        script (str "var schema = " schema ";"
                    "var schemaData = schema.data;"
                    "var getBabelRelayPlugin = require('babel-relay-plugin');"
                    "var babel = require('babel-core');"
                    "var code = '" code "';"
                    "var options = {};"
                    "options.plugins = [getBabelRelayPlugin(schemaData)];"
                    "options.filename = '" filename "';"
                    "options.compact = true;"
                    "options.comments = false;"
                    "babel.transform(code, options).code;")]
    (conch/execute "node" "--print" script)))

(defmacro ql [^String query]
  `(js/eval ~(ql* &env query)))
```

It's hacky, but it works (even in advanced compilation).

You'll need Node as well as `babel-core` and `babel-relay-plugin`.
The version of `babel-relay-plugin` must exactly match the version `react-relay`.

For embedding fragments, fully qualify the fragment component (e.g., `"${my.ui.MyComponent.getFragment(\"viewer\")}"`)
when referenced in GraphQL and export the component where it is defined (e.g., `(def ^:export MyComponent ...)`).

[babel]: https://babeljs.io/
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
