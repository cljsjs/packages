"use strict";

var Matter = {
    "Body": {
        "create": function () {},
        "nextGroupId": function () {},
        "setStatic": function () {},
        "resetForcesAll": function () {},
        "applyGravityAll": function () {},
        "updateAll": function () {},
        "update": function () {},
        "applyForce": function () {},
        "translate": function () {},
        "rotate": function () {},
        "scale": function () {}
    },
    "Composite": {
        "create": function () {},
        "setModified": function () {},
        "add": function () {},
        "remove": function () {},
        "addComposite": function () {},
        "removeComposite": function () {},
        "removeCompositeAt": function () {},
        "addBody": function () {},
        "removeBody": function () {},
        "removeBodyAt": function () {},
        "addConstraint": function () {},
        "removeConstraint": function () {},
        "removeConstraintAt": function () {},
        "clear": function () {},
        "allBodies": function () {},
        "allConstraints": function () {},
        "allComposites": function () {},
        "get": function () {},
        "move": function () {},
        "rebase": function () {}
    },
    "World": {
        "create": function () {},
        "add": function () {},
        "remove": function () {},
        "addComposite": function () {},
        "addBody": function () {},
        "addConstraint": function () {},
        "clear": function () {}
    },
    "Contact": {
        "create": function () {},
        "id": function () {}
    },
    "Detector": {
        "collisions": function () {},
        "bruteForce": function () {}
    },
    "Grid": {
        "create": function () {},
        "update": function () {},
        "clear": function () {}
    },
    "Pairs": {
        "create": function () {},
        "update": function () {},
        "removeOld": function () {},
        "clear": function () {}
    },
    "Pair": {
        "create": function () {},
        "update": function () {},
        "setActive": function () {},
        "id": function () {}
    },
    "Resolver": {
        "solvePosition": function () {},
        "postSolvePosition": function () {},
        "preSolveVelocity": function () {},
        "solveVelocity": function () {}
    },
    "SAT": {
        "collides": function () {}
    },
    "Constraint": {
        "create": function () {},
        "solveAll": function () {},
        "solve": function () {},
        "postSolveAll": function () {}
    },
    "MouseConstraint": {
        "create": function () {},
        "update": function () {}
    },
    "Common": {
        "_nextId": {},
        "extend": function () {},
        "clone": function () {},
        "keys": function () {},
        "values": function () {},
        "shadeColor": function () {},
        "shuffle": function () {},
        "choose": function () {},
        "isElement": function () {},
        "clamp": function () {},
        "sign": function () {},
        "now": function () {},
        "random": function () {},
        "colorToNumber": function () {},
        "log": function () {},
        "nextId": function () {}
    },
    "Engine": {
        "create": function () {},
        "run": function () {},
        "update": function () {},
        "render": function () {},
        "merge": function () {},
        "clear": function () {}
    },
    "Metrics": {
        "create": function () {},
        "reset": function () {},
        "update": function () {}
    },
    "Mouse": function () {},
    "Sleeping": {
        "update": function () {},
        "afterCollisions": function () {},
        "set": function () {}
    },
    "Bodies": {
        "rectangle": function () {},
        "trapezoid": function () {},
        "circle": function () {},
        "polygon": function () {}
    },
    "Composites": {
        "stack": function () {},
        "chain": function () {},
        "mesh": function () {},
        "pyramid": function () {},
        "newtonsCradle": function () {},
        "car": function () {},
        "softBody": function () {}
    },
    "Axes": {
        "fromVertices": function () {},
        "rotate": function () {}
    },
    "Bounds": {
        "create": function () {},
        "update": function () {},
        "contains": function () {},
        "overlaps": function () {},
        "translate": function () {},
        "shift": function () {}
    },
    "Vector": {
        "magnitude": function () {},
        "magnitudeSquared": function () {},
        "rotate": function () {},
        "rotateAbout": function () {},
        "normalise": function () {},
        "dot": function () {},
        "cross": function () {},
        "add": function () {},
        "sub": function () {},
        "mult": function () {},
        "div": function () {},
        "perp": function () {},
        "neg": function () {},
        "angle": function () {}
    },
    "Vertices": {
        "create": function () {},
        "fromPath": function () {},
        "centre": function () {},
        "area": function () {},
        "inertia": function () {},
        "translate": function () {},
        "rotate": function () {},
        "contains": function () {},
        "scale": function () {},
        "chamfer": function () {}
    },
    "Render": {
        "create": function () {},
        "clear": function () {},
        "setBackground": function () {},
        "world": function () {},
        "debug": function () {},
        "constraints": function () {},
        "bodyShadows": function () {},
        "bodies": function () {},
        "bodyWireframes": function () {},
        "bodyBounds": function () {},
        "bodyAxes": function () {},
        "bodyPositions": function () {},
        "bodyVelocity": function () {},
        "bodyIds": function () {},
        "collisions": function () {},
        "grid": function () {},
        "inspector": function () {}
    },
    "RenderPixi": {
        "create": function () {},
        "clear": function () {},
        "setBackground": function () {},
        "world": function () {},
        "constraint": function () {},
        "body": function () {}
    },
    "Events": {
        "on": function () {},
        "off": function () {},
        "trigger": function () {}
    },
    "Query": {
        "ray": function () {},
        "region": function () {}
    }
};
