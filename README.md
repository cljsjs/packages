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

## Using a package

When using the `from-cljsjs` boot task there is an option to determine
which directory's files will be added to the [fileset][fileset-doc]:

```clj
(require '[cljsjs.app :refer [from-cljsjs]])

(from-cljsjs :profile :development)
; This will add files in cljsjs/common and files
; in cljsjs/developmet to the fileset

(from-cljsjs :profile :production)
; This will add files in cljsjs/common and files
; in cljsjs/production to the fileset
```

[fileset-doc]: https://github.com/boot-clj/boot/wiki/Filesets
[boot-cljsjs]: https://github.com/cljsjs/boot-cljsjs
[build.boot]: https://github.com/cljsjs/packages/blob/877c048b50d98bdccb072bde588617b90734c1a8/react/build.boot
