# CLJSJS Packages

<img src="https://dl.dropboxusercontent.com/u/453692/cljsjs-logo.png"
  alt="CLJSJS logo" align="right" />

**Transitioning to :foreign-libs right now.**

> These packages originally only worked out of the box with Boot.
> Existing versions will continue to work, future versions will
> work through the `:foreign-libs` mechanism supplied by Clojurescript.

## Using these packages

All packages provided by [cljsjs][clojars-cljsjs] provide `deps.cljs`
files that will be automtically picked up by the Clojurescript
compiler as of [0.0-2727][2727]. Versions of the Jar reflect the
version of the packaged JS lib.

**You can find the specific coordinates for those packages in their
respective `README` files.**

## Documentation

The wiki of this repo is used for community maintained documentation:

- [Why CLJSJS exists](https://github.com/cljsjs/packages/wiki)
- [Creating Packages](https://github.com/cljsjs/packages/wiki/Creating-Packages)
- [Creating Externs](https://github.com/cljsjs/packages/wiki/Creating-Externs)

If you'd like to contribute there's a
[small section on that](https://github.com/cljsjs/packages/wiki#contribute)
as well.

[fileset-doc]: https://github.com/boot-clj/boot/wiki/Filesets
[boot-cljsjs]: https://github.com/cljsjs/boot-cljsjs
[build.boot]: react/build.boot
[clojars-cljsjs]: https://clojars.org/groups/cljsjs
[2727]: https://groups.google.com/d/msg/clojurescript/pJ_EYHkYAUs/mLi8XfiQxZsJ
