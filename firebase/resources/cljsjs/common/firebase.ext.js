/**
   Externs for Firebase v3
*/

/**
   Firebase Global Namespace
*/
var firebase = {};

/**
   @param {Object}  options
   @param {String=} name
   @return {firebase.app.App}
*/

firebase.initializeApp = function(options, name) {};

/**
   @param {String=} name
   @return {firebase.app.App}
*/

firebase.app = function(name) {};

/**
   @param {String=} name
   @return {firebase.auth.Auth}
*/

firebase.auth = function(name) {};

/**
   @param {String=} name
   @return {firebase.database.Database}
*/

firebase.database = function(name) {};

/**
   @param {String=} name
   @return {firebase.storage.Storage}
*/

firebase.storage = function(name) {};

/**
   @return {Object}
*/

firebase.apps = function() {};
