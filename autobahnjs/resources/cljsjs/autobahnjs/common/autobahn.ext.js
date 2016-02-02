// http://jmmk.github.io/javascript-externs-generator/
var autobahn = {
    "version": {},
    "transports": {},
    "Connection": function () {},
    "Session": function () {},
    "Invocation": function () {},
    "Event": function () {},
    "Result": function () {},
    "Error": function () {},
    "Subscription": function () {},
    "Registration": function () {},
    "Publication": function () {},
    "auth_persona": function () {},
    "auth_cra": {
        "sign": function () {},
        "derive_key": function () {}
    },
    "when": {
        "promise": function () {},
        "resolve": function () {},
        "reject": function () {},
        "lift": function () {},
        "try": function () {},
        "attempt": function () {},
        "iterate": function () {},
        "unfold": function () {},
        "join": function () {},
        "all": function () {},
        "settle": function () {},
        "any": function () {},
        "some": function () {},
        "race": function () {},
        "map": function () {},
        "filter": function () {},
        "reduce": function () {},
        "reduceRight": function () {},
        "isPromiseLike": function () {},
        "Promise": {
            "resolve": function () {},
            "reject": function () {},
            "never": function () {},
            "_defer": function () {},
            "_handler": function () {},
            "all": function () {},
            "race": function () {},
            "_traverse": function () {},
            "_visitRemaining": function () {},
            "onFatalRejection": function () {},
            "onPotentiallyUnhandledRejectionHandled": function () {},
            "onPotentiallyUnhandledRejection": function () {},
            "exitContext": function () {},
            "enterContext": function () {},
            "createContext": function () {},
            "any": function () {},
            "some": function () {},
            "settle": function () {},
            "map": function () {},
            "filter": function () {},
            "reduce": function () {},
            "reduceRight": function () {},
            "iterate": function () {},
            "unfold": function () {}
        },
        "defer": function () {},
        "TimeoutError": function () {}
    },
    "util": {
        "rand_normal": function () {},
        "assert": function () {},
        "http_post": function () {},
        "defaults": function () {}
    },
    "log": {
        "debug": function () {}
    }
};
autobahn.Connection.prototype = {
    "_create_transport": function () {},
    "_init_transport_factories": function () {},
    "_autoreconnect_reset_timer": function () {},
    "_autoreconnect_reset": function () {},
    "_autoreconnect_advance": function () {},
    "open": function () {},
    "close": function () {}
};
autobahn.Session.prototype = {
    "log": function () {},
    "join": function () {},
    "leave": function () {},
    "call": function () {},
    "publish": function () {},
    "subscribe": function () {},
    "register": function () {},
    "unsubscribe": function () {},
    "unregister": function () {},
    "prefix": function () {},
    "resolve": function () {}
};
autobahn.Subscription.prototype = {
    "unsubscribe": function () {}
};
autobahn.Registration.prototype = {
    "unregister": function () {}
};
autobahn.when.Promise.prototype = {
    "then": function () {},
    "catch": function () {},
    "_beget": function () {},
    "spread": function () {},
    "done": function () {},
    "otherwise": function () {},
    "ensure": function () {},
    "finally": function () {},
    "orElse": function () {},
    "else": function () {},
    "yield": function () {},
    "tap": function () {},
    "fold": function () {},
    "progress": function () {},
    "inspect": function () {},
    "withThis": function () {},
    "with": function () {},
    "delay": function () {},
    "timeout": function () {}
};
autobahn.when.TimeoutError.prototype = {
    "constructor": function () {}
};