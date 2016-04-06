/** @constructor */
function PouchDB() {}

/* In order of appearance on http://pouchdb.com/api.html */
PouchDB.prototype.destroy = function () {};
PouchDB.prototype.put = function () {};
PouchDB.prototype.get = function () {};
PouchDB.prototype.post = function () {};
PouchDB.prototype.remove = function () {};
PouchDB.prototype.bulkDocs = function () {};
PouchDB.prototype.allDocs = function () {};
PouchDB.prototype.changes = function () {};
PouchDB.prototype.replicate = function () {};
PouchDB.prototype.sync = function () {};
PouchDB.prototype.putAttachment = function () {};
PouchDB.prototype.getAttachment = function () {};
PouchDB.prototype.removeAttachment = function () {};
PouchDB.prototype.query = function () {};
PouchDB.prototype.viewCleanup = function () {};
PouchDB.prototype.info = function () {};
PouchDB.prototype.compact = function () {};
PouchDB.prototype.revsDiff = function () {};

/* This part of the externs file was created from PouchDB 3.4.0 using
 * http://www.dotnetwise.com/Code/Externs/
 */
var PouchDB = {
    "super_": function () {},
    "debug": function () {},
    "adapters": {
        "http": function () {},
        "https": function () {},
        "idb": function () {},
        "websql": function () {}
    },
    "preferredAdapters": {
        "0": {},
        "1": {}
    },
    "prefix": {},
    "on": function () {},
    "addListener": function () {},
    "emit": function () {},
    "listeners": function () {},
    "once": function () {},
    "removeAllListeners": function () {},
    "removeListener": function () {},
    "setMaxListeners": function () {},
    "parseAdapter": function () {},
    "adapter": function () {},
    "plugin": function () {},
    "defaults": function () {},
    "ajax": function () {},
    "utils": {
        "extend": function () {},
        "ajax": function () {},
        "createBlob": function () {},
        "uuid": function () {},
        "getArguments": function () {},
        "Map": function () {},
        "Set": function () {},
        "Promise": function () {},
        "lastIndexOf": function () {},
        "clone": function () {},
        "pick": function () {},
        "inherits": function () {},
        "call": function () {},
        "isLocalId": function () {},
        "isDeleted": function () {},
        "revExists": function () {},
        "filterChange": function () {},
        "parseDoc": function () {},
        "invalidIdError": function () {},
        "isCordova": function () {},
        "hasLocalStorage": function () {},
        "Changes": function () {},
        "atob": function () {},
        "btoa": function () {},
        "fixBinary": function () {},
        "readAsBinaryString": function () {},
        "readAsArrayBuffer": function () {},
        "once": function () {},
        "toPromise": function () {},
        "adapterFun": function () {},
        "arrayBufferToBinaryString": function () {},
        "cancellableFun": function () {},
        "MD5": function () {},
        "explain404": function () {},
        "info": function () {},
        "parseUri": function () {},
        "compare": function () {},
        "updateDoc": function () {},
        "processDocs": function () {},
        "preprocessAttachments": function () {},
        "compactTree": function () {},
        "safeJsonParse": function () {},
        "safeJsonStringify": function () {}
    },
    "Errors": {
        "UNAUTHORIZED": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "MISSING_BULK_DOCS": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "MISSING_DOC": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "REV_CONFLICT": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "INVALID_ID": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "MISSING_ID": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "RESERVED_ID": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "NOT_OPEN": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "UNKNOWN_ERROR": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "BAD_ARG": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "INVALID_REQUEST": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "QUERY_PARSE_ERROR": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "DOC_VALIDATION": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "BAD_REQUEST": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "NOT_AN_OBJECT": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "DB_MISSING": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "IDB_ERROR": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "WSQ_ERROR": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "LDB_ERROR": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "FORBIDDEN": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "INVALID_REV": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "FILE_EXISTS": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "MISSING_STUB": {
            "status": {},
            "name": {},
            "message": {},
            "error": {},
            "toString": function () {}
        },
        "error": function () {},
        "getErrorTypeByProp": function () {},
        "generateErrorFromResponse": function () {}
    },
    "replicate": function () {},
    "sync": function () {},
    "version": {}
};
PouchDB.replicate.to = function() {};
PouchDB.replicate.from = function() {};
