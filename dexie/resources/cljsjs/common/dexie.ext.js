var Dexie = {
  "delete": function () {},
  "exists": function () {},
  "getDatabaseNames": function () {},
  "defineClass": function () {},
  "ignoreTransaction": function () {},
  "spawn": function () {},
  "vip": function () {},
  "Promise": function () {},
  "derive": function () {},
  "extend": function () {},
  "override": function () {},
  "events": function () {},
  "getByKeyPath": function () {},
  "setByKeyPath": function () {},
  "delByKeyPath": function () {},
  "shallowClone": function () {},
  "deepClone": function () {},
  "addons": function () {},
  "fakeAutoComplete": function () {},
  "asap": function () {},
  "ModifyError": function () {},
  "MultiModifyError": function () {},
  "IndexSpec": function () {},
  "TableSchema": function () {},
  "dependencies": {
    "indexedDB": {
      "webkitGetDatabaseNames": function () {},
      "open": function () {},
      "deleteDatabase": function () {},
      "cmp": function () {}
    },
    "IDBKeyRange": function () {},
    "IDBTransaction": function () {},
    "Error": function () {},
    "SyntaxError": function () {},
    "TypeError": function () {},
    "DOMError": function () {},
    "localStorage": function () {}
  },
  "version": {}
};

var Version = function () {};
Version.prototype.stores = function (stores) {};

var Table = function () {};
Table.prototype.get = function (keyOrCrit, cb) {};
Table.prototype.where = function (indexOrCrit) {};
Table.prototype.count = function (cb) {};
Table.prototype.offset = function (offset) {};
Table.prototype.limit = function (numRows) {};
Table.prototype.reverse = function () {};
Table.prototype.filter = function (filterFunction) {};
Table.prototype.each = function (fn) {};
Table.prototype.toArray = function (cb) {};
Table.prototype.orderBy = function (index) {};
Table.prototype.toCollection = function () {};
Table.prototype.mapToClass = function (constructor, structure) {};
Table.prototype.defineClass = function (structure) {};
Table.prototype.bulkDelete = function (keys) {};
Table.prototype.bulkPut = function (objects, keys) {};
Table.prototype.bulkAdd = function (objects, keys) {};
Table.prototype.add = function (obj, key) {};
Table.prototype.put = function (obj, key) {};
Table.prototype.delete = function (key) {};
Table.prototype.clear = function () {};
Table.prototype.update = function (keyOrObject, modifications) {};

var WhereClause = function () {};
WhereClause.prototype.between = function (lower, upper, includeLower, includeUpper) {};
WhereClause.prototype.equals = function (value) {};
WhereClause.prototype.above = function (value) {};
WhereClause.prototype.aboveOrEqual = function (value) {};
WhereClause.prototype.below = function (value) {};
WhereClause.prototype.belowOrEqual = function (value) {};
WhereClause.prototype.startsWith = function (str) {};
WhereClause.prototype.startsWithIgnoreCase = function (str) {};
WhereClause.prototype.equalsIgnoreCase = function (str) {};
WhereClause.prototype.anyOfIgnoreCase = function () {};
WhereClause.prototype.startsWithAnyOfIgnoreCase = function () {};
WhereClause.prototype.anyOf = function () {};
WhereClause.prototype.notEqual = function (value) {};
WhereClause.prototype.noneOf = function () {};
WhereClause.prototype.inAnyRange = function (ranges, options) {};
WhereClause.prototype.startsWithAnyOf = function () {};

var Collection = function () {};
Collection.prototype.each = function (fn) {};
Collection.prototype.count = function (cb) {};
Collection.prototype.sortBy = function (keyPath, cb) {};
Collection.prototype.toArray = function (cb) {};
Collection.prototype.offset = function (offset) {};
Collection.prototype.limit = function (numRows) {};
Collection.prototype.until = function (filterFunction, bIncludeStopEntry) {};
Collection.prototype.first = function (cb) {};
Collection.prototype.last = function (cb) {};
Collection.prototype.filter = function (filterFunction) {};
Collection.prototype.and = function (filterFunction) {};
Collection.prototype.or = function (indexName) {};
Collection.prototype.reverse = function () {};
Collection.prototype.desc = function () {};
Collection.prototype.eachKey = function (cb) {};
Collection.prototype.eachUniqueKey = function (cb) {};
Collection.prototype.eachPrimaryKey = function (cb) {};
Collection.prototype.keys = function (cb) {};
Collection.prototype.primaryKeys = function (cb) {};
Collection.prototype.uniqueKeys = function (cb) {};
Collection.prototype.firstKey = function (cb) {};
Collection.prototype.lastKey = function (cb) {};
Collection.prototype.distinct = function () {};
Collection.prototype.modify = function (changes) {};
Collection.prototype.delete = function () {};
