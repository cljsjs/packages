(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/bigfraction
       :version     +version+
       :description "BigFraction is an arbitrary precision version of Fraction,
       a rational number library written in JavaScript."
       :url         "https://github.com/infusion/Fraction.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-fraction []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
   (build-fraction)
   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"10 \*\* Math.floor\(1 \+ Math.log10\(p1\)\);"
                    :value "Math.pow(10, Math.floor(1 + Math.log10(p1)));")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"C_TEN \*\* BigInt\(match\[ndx\].length\);"
                    :value "Math.pow(C_TEN, BigInt(match[ndx].length));")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"C_TEN \*\* BigInt\(match\[ndx \+ 1\].length\)"
                    :value "Math.pow(C_TEN, BigInt(match[ndx + 1].length))")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"\(this\['s'\] \* this\[\"d\"\]\) \*\* P\['n'\]"
                    :value "Math.pow((this['s'] * this[\"d\"]), P['n'])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"\(this\['s'\] \* this\[\"n\"\]\) \*\* P\['n'\]"
                    :value "Math.pow((this['s'] * this[\"n\"]), P['n'])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"this\[\"n\"\] \*\* P\['n'\]"
                    :value "Math.pow(this[\"n\"], P['n'])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"this\[\"d\"\] \*\* P\['n'\]"
                    :value "Math.pow(this[\"d\"], P['n'])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"BigInt\(k\) \*\* N\[k\]"
                    :value "Math.pow(BigInt(k), N[k])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"BigInt\(k\) \*\* D\[k\]"
                    :value "Math.pow(BigInt(k), D[k])")

   (replace-content :in "bigfraction.bundle.js"
                    :out "bigfraction.bundle.js"
                    :match #"10 \*\* Number\(places \|\| 0\)"
                    :value "Math.pow(10, Number(places || 0))")

   (sift :move {#".*bigfraction.bundle.js" "cljsjs/fraction/development/bigfraction.inc.js"
                #".*bigfraction.ext.js" "cljsjs/fraction/common/bigfraction.ext.js"})
   (minify    :in  "cljsjs/fraction/development/bigfraction.inc.js"
              :out "cljsjs/fraction/production/bigfraction.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :provides ["fraction.js/bigfraction.js", "cljsjs.bigfraction"]
              :requires []
              :global-exports '{fraction.js/bigfraction.js BigFraction
                                cljsjs.bigfraction BigFraction})
   (pom)
   (jar)
   (validate-checksums)))
