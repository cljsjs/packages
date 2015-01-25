# CLJSJS Packages

<img src="https://dl.dropboxusercontent.com/u/453692/cljsjs-logo.png"
  alt="CLJSJS logo" align="right" />

**Transitioning to :foreign-libs right now.**

> These packages originally only worked out of the box with Boot.
> Existing versions will continue to work, future versions will
> work through the `:foreign-libs` mechanism supplied by Clojurescript.

# Using these packages

All packages provided by [cljsjs][clojars-cljsjs] provide `deps.cljs`
files that will be automtically picked up by the Clojurescript
compiler as of [0.0-2727][2727]. Versions of the Jar reflect the
version of the packaged JS lib.

You can find the specific coordinates for those packages in their
respective `README` files.

## Contributing a package

There are a bunch of tasks for Boot in [boot-cljsjs][boot-cljsjs] that help with
packaging these jars. If you are curious how they work, I recommend checking out
the individual `build.boot` files in the subdirectories of this repository.

**If you just want a JS library to be packaged up, feel free to open
an issue, chances are someone might just do it for you.**

Please note that packaging other things besides plain JS libraries is
a bit more complex and is currently out of scope for this project. If you
have suggestions or ideas to change this, open an issue :)

[fileset-doc]: https://github.com/boot-clj/boot/wiki/Filesets
[boot-cljsjs]: https://github.com/cljsjs/boot-cljsjs
[build.boot]: react/build.boot
[clojars-cljsjs]: https://clojars.org/groups/cljsjs
[2727]: https://groups.google.com/d/msg/clojurescript/pJ_EYHkYAUs/mLi8XfiQxZsJ
