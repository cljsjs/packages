var airbrakeJs = {};

var Client = {
    "Client": {
      "_projectId": {},
      "_projectKey": {},
      "_host": {},
      "_processor": {},
      "_reporters": {},
      "_filters": {},
      "prototype": {
            "setProject": function () {},
            "setHost": function () {},
            "addContext": function () {},
            "setEnvironmentName": function () {},
            "addParams": function () {},
            "addEnvironment": function () {},
            "addSession": function () {},
            "addReporter": function () {},
            "addFilter": function () {},
            "notify": function () {},
            "push": function () {},
            "_wrapArguments": function () {},
            "wrap": function () {}
        }
    }
}

var base = {};
var jsonifyNotice = {};
var truncate = {};
var truncateObj = {};
var cbCount = {};
var merge = {};

var Promise = {
    "Promise": {
        "prototype": {
            "then": function () {},
            "catch": function () {},
            "resolve": function () {},
            "reject": function () {}
        }
    }
}

var getAttr = function(obj, attr) {};
var truncate = function(value, n, depth) {};

var typeMessageRe;
var rules = [];

var processor = function(e, cb) {};

var report = function(notice, opts, promise) {};
