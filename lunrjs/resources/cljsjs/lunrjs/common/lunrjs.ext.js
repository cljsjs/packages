var lunr = function(arg1) {};

lunr.version = "0.6.0";
lunr.utils = {}
lunr.utils.warn = function(global) {};
lunr.utils.asString = function(obj) {};

lunr.EventEmitter = function () {};
lunr.EventEmitter.prototype.addListener = function () {};
lunr.EventEmitter.prototype.removeListener = function (name, fn) {};
lunr.EventEmitter.prototype.emit = function (name) {};
lunr.EventEmitter.prototype.hasHandler = function (name) {};

lunr.tokenizer = function (obj) {};
lunr.tokenizer.seperator =  /[\s\-]+/;

lunr.Pipeline = function () {};
lunr.Pipeline.registeredFunctions = {};
lunr.Pipeline.registerFunction = function (fn, label) {};
lunr.Pipeline.warnIfFunctionNotRegistered = function (fn) {};
lunr.Pipeline.load = function (serialised) {};
lunr.Pipeline.prototype.add = function () {};
lunr.Pipeline.prototype.after = function (existingFn, newFn) {};
lunr.Pipeline.prototype.before = function (existingFn, newFn) {};
lunr.Pipeline.prototype.remove = function (fn) {};
lunr.Pipeline.prototype.run = function (tokens) {};
lunr.Pipeline.prototype.reset = function () {};
lunr.Pipeline.prototype.toJSON = function () {};

lunr.Vector = function () {};
lunr.Vector.Node = function (idx, val, next) {};
lunr.Vector.prototype.insert = function (idx, val) {};
lunr.Vector.prototype.magnitude = function () {};
lunr.Vector.prototype.dot = function (otherVector) {};
lunr.Vector.prototype.similarity = function (otherVector) {};

lunr.SortedSet = function () {};
lunr.SortedSet.load = function (serialisedData) {};
lunr.SortedSet.prototype.add = function () {};
lunr.SortedSet.prototype.toArray = function () {};
lunr.SortedSet.prototype.map = function (fn, ctx) {};
lunr.SortedSet.prototype.forEach = function (fn, ctx) {};
lunr.SortedSet.prototype.indexOf = function (elem) {};
lunr.SortedSet.prototype.locationFor = function (elem) {};
lunr.SortedSet.prototype.intersect = function (otherSet) {};
lunr.SortedSet.prototype.clone = function () {};
lunr.SortedSet.prototype.union = function (otherSet) {};
lunr.SortedSet.prototype.toJSON = function () {};

lunr.Index = function () {};
lunr.Index.prototype.on = function() {};
lunr.Index.prototype.off = function(name, fn) {};
lunr.Index.prototype.load = function(serialisedData) {};
lunr.Index.prototype.field = function(fieldName, opts) {};
lunr.Index.prototype.ref = function(refName) {};
lunr.Index.prototype.add = function(doc, emitEvent) {};
lunr.Index.prototype.remove = function (doc, emitEvent) {};
lunr.Index.prototype.update = function (doc, emitEvent) {};
lunr.Index.prototype.idf = function (term) {};
lunr.Index.prototype.search = function (query) {};
lunr.Index.prototype.documentVector = function (documentRef) {};
lunr.Index.prototype.toJSON = function () {};
lunr.Index.prototype.use = function (plugin) {};

lunr.Store = function () {};
lunr.Store.load = function (serialisedData) {};
lunr.Store.prototype.set = function (id, tokens) {};
lunr.Store.prototype.get = function (id) {};
lunr.Store.prototype.has = function (id) {};
lunr.Store.prototype.remove = function (id) {};
lunr.Store.prototype.toJSON = function () {};

lunr.stemmer = function(w) {};
lunr.generateStopWordFilter = function (stopWords) {};
lunr.stopWordFilter = function(token) {};

lunr.trimmer = function (token) {};

lunr.TokenStore = function () {};
lunr.TokenStore.load = function (serialisedData) {};
lunr.TokenStore.prototype.add = function (token, doc, root) {};
lunr.TokenStore.prototype.has = function (token) {};
lunr.TokenStore.prototype.getNode = function (token) {};
lunr.TokenStore.prototype.get = function (token, root) {};
lunr.TokenStore.prototype.count = function (token, root) {};
lunr.TokenStore.prototype.remove = function (token, ref) {};
lunr.TokenStore.prototype.expand = function (token, memo) {};
lunr.TokenStore.prototype.toJSON = function () {};
