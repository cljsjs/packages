# CLJSJS Packages

<img src="https://dl.dropboxusercontent.com/u/453692/cljsjs-logo.png"
  alt="CLJSJS logo" align="right" />

This repository contains CLJSJS packages. You can use them using the
`from-cljsjs` task that is part of [boot-cljsjs][boot-cljsjs].
If you want to use these jars from Leiningen: the files in the `resources`
directory will be directly available on the classpath.

## Contributing a package

The directory structure for individual packages needs to look similar to this:

```
build.boot
resources/
└──  cljsjs/
    ├──  common/
    │   └──  react-externs.ext.js
    ├──  development/
    │   └──  react-0.12.2.inc.js
    └──  production/
        └──  react-0.12.2.min.inc.js
```

1. The `build.boot` file specifies general information about the package (an [example][build.boot])
1. The `cljsjs/common` directory is usually used for externs.
1. The `cljsjs/development` directory should contain an unminified version of the packaged Javascript library.
1. The `cljsjs/production` directory should contain a minified version of the packaged Javascript library.

Files that should be included as a preamble, like minified or
unminified libraries, should end in `.inc.js`. Extern files for
the Google Closure compiler should always end in `.ext.js`.

The jar version should always reflect the version of the packaged library,
for updated builds `-0`, `-1` etc. can be appended to the version string.

## Using a package

Using the `from-cljsjs` task from [boot-cljsjs][boot-cljsjs] using a
package will look somewhat like this:

```clj
;; in your build.boot file:
(set-env!
  :source-paths #{"src"}
  :dependencies '[[adzerk/boot-cljs   "0.0-2629-1" :scope "test"]
                  [cljsjs/boot-cljsjs "0.3.1"      :scope "test"]
                  [cljsjs/react       "0.12.2-2"]
                  [reagent            "0.4.3"]]

(require '[adzerk.boot-cljs :refer [cljs]]
         '[cljsjs.boot-cljsjs :refer [from-cljsjs]])

(deftask build-dev []
  (comp
    (from-cljsjs :profile :development)
    (cljs :optimizations :none)))

(deftask build-prod []
  (comp
    (from-cljsjs :profile :production)
    (cljs :optimizations :advanced)))
```

[fileset-doc]: https://github.com/boot-clj/boot/wiki/Filesets
[boot-cljsjs]: https://github.com/cljsjs/boot-cljsjs
[build.boot]: react/build.boot
