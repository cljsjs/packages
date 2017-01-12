# cljsjs/liquidfun

[](dependency)
```clojure
[cljsjs/liquidfun "1.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing
[Google's `liquidfun`](https://github.com/google/liquidfun),
a 2D physics simulator based on Box2D.

```clojure
(ns liquidfun.example
  (:require cljsjs.liquidfun))

(let [w (js/b2World. (js/b2Vec2. -10 0))
  (js/console.log "A small world: " w))
```

### Externs file

The externs file was generated from files in liquidfun's
`liquidfun/Box2D/lfjs/` directory:

```shell
for f in jsBindings/*/*.js jsBindings/*/*/*.js ; do (cat "${f}"; echo); done >tmp_js
cat tmp_js | sed 's/^  this/this/g' | grep -v "^ " | grep -v "=$" | \
  grep -v "Module.cwrap" | grep -v "= Offsets" | grep -v "this.buffer.set" | \
  sed 's/= null/= {}/g' | sed 's/= new .*/= {};/g' | grep -v "^$" \
  >liquidfun.ext.js
```

A few manual adjustments are needed.
Delete this malformed block (it is not required):
```
b2PulleyJointDef.prototype.InitializeAndCreate  = function(bodyA, bodyB, groundAnchorA,
this.bodyA = bodyA;
this.bodyB = bodyB;
};
```

Add these missing props in `b2RevoluteJointDef`
```
this.bodyA = {};
this.bodyB = {};
```

Add this line inside `b2World.prototype.QueryAABB` and `b2World.prototype.Raycast`
```
callback.ReportFixture = function() {};
```

Add these lines inside `b2World.prototype.SetContactListener`
```
listener.BeginContactBody = function() {};
listener.EndContactBody = function() {};
listener.PreSolve = function() {};
listener.PostSolve = function() {};
```

Finally, silence the Closure compiler (advanced mode) warnings by deleting
the relevant lines in prototype functions, or in constructors replacing function
calls with constants. Total lines changed: 8.
