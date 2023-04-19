# Cljsjs is deprecated

The most common packages like React will continue to be maintained in Cljsjs.
But there are better alternatives for using JS libraries.

Maintainers might still accept PRs but if you are just adding a library for
use in your application, consider alternatives before creating a PR.

## Why does Cljsjs exist

- To allow easy use of JS libraries from Cljs -> **No longer needed**
- To ensure there is only single copy of the JS library in classpath -> **Still relevant, in some cases**

## Why isn't Cljsjs perfect

- Centralized repository needs maintainers to review and merge PRs
- Outdated tooling, open issues with tooling

## Better solutions

### Using a JS library from a application project

Use [shadow-cljs](https://shadow-cljs.github.io/docs/UsersGuide.html) or
[ClojureScript with Webpack](https://clojurescript.org/guides/webpack) to
directly consume npm packages. You always get access to up-to-date versions.

### Using a JS library from a Cljs library

Depending on your library, you could just require that the consumers of your
library use shadow-cljs or webpack to provide requires JS libraries. If you
need to ensure users can use the library with foreign-libraries, you could
package the JS library yourself as a JAR, same as what cljsjs does, but you can
do this yourself using Leiningen or clj.

Compared to Cljsjs, you need to create a bit of tooling yourself, but you are
free to update the JS library yourself.

# CLJSJS Packages

<img src="http://cljsjs.github.io/cljsjs.svg" alt="CLJSJS logo" align="right" />

CLJSJS is an effort to package Javascript libraries to be able to use
them from within ClojureScript.

## Using these packages

All packages provided by [cljsjs][clojars-cljsjs] provide `deps.cljs`
files that will be automatically picked up by the ClojureScript
compiler as of [0.0-2727][2727]. Versions of the Jar reflect the
version of the packaged JS lib.

**You can find the specific coordinates for those packages in their
respective `README` files.**

## Documentation

The wiki of this repo is used for community maintained documentation:

- [Why CLJSJS exists](https://github.com/cljsjs/packages/wiki)
- [Using Packages](https://github.com/cljsjs/packages/wiki/Using-Packages)
- [Creating Packages](https://github.com/cljsjs/packages/wiki/Creating-Packages)
- [Creating Externs](https://github.com/cljsjs/packages/wiki/Creating-Externs)

If you'd like to contribute there's a
[small section on that](https://github.com/cljsjs/packages/wiki#contribute)
as well.

## For information and help

[Clojurians slack](https://clojurians.slack.com/) ([join](http://clojurians.net/))
has a channel [#cljsjs](https://clojurians.slack.com/messages/cljsjs/) for talk about Cljsjs.

[fileset-doc]: https://github.com/boot-clj/boot/wiki/Filesets
[boot-cljsjs]: https://github.com/cljsjs/boot-cljsjs
[build.boot]: react/build.boot
[clojars-cljsjs]: https://clojars.org/groups/cljsjs
[2727]: https://groups.google.com/d/msg/clojurescript/pJ_EYHkYAUs/mLi8XfiQxZsJ
