// Manually coded the callback and request interfaces (the generator couldn't).
// This covers the main API described on OAuth project README but not User API.

var OAuth = {};

// types

/** @interface */
function OACallback() {};
OACallback.prototype.done = function() {};
OACallback.prototype.fail = function() {};

/** @interface */
function OARequest() {};
/** @return {!OACallback} */
OARequest.prototype.get = function() {};
/** @return {!OACallback} */
OARequest.prototype.post = function() {};
/** @return {!OACallback} */
OARequest.prototype.put = function() {};
/** @return {!OACallback} */
OARequest.prototype.delete = function() {};
/** @return {!OACallback} */
OARequest.prototype.patch = function() {};

// main API

/** @return {!OACallback} */
OAuth.callback = function() {};

OAuth.clearCache = function() {};

/** @return {!OARequest} */
OAuth.create = function() {};

OAuth.getVersion = function() {};
OAuth.http = function() {};
OAuth.http_me = function() {};
OAuth.initialize = function() {};

/** @return {!OACallback} */
OAuth.me = function() {};

// see below:
OAuth.popup = function() {};

/** @return {!OARequest} */
OAuth.popup.done = function() {};

OAuth.popup.fail = function() {};

OAuth.redirect = function() {};
OAuth.setOAuthdURL = function() {};
