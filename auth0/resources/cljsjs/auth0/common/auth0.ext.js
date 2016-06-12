/**
 * @externs
 */

/**
 * @param {Object} options
 * @constructor
 */
var Auth0 = function(options) {};

/**
 * @type {string}
 */
Auth0.version;


/**
 * @param {string} id_token
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.getProfile = function(id_token, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.validateUser = function(options, callback) {};

/**
 * @param {string} jwt
 * @return {object}
 */
Auth0.prototype.decodeJwt = function(jwt) {};

/**
 * @param {string} hash
 * @return {object}
 */
Auth0.prototype.parseHash = function(hash) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.signup = function(options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.changePassword = function(options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.login = function(options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.signin = function(options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.loginWithResourceOwner = function (options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.loginWithSocialAccessToken = function (options, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.loginWithPhoneNumber = function (options, callback) {};

/**
 * @param {string} id_token
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.renewIdToken = function (id_token, callback) {};

/**
 * @param {string} refresh_token
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.refreshToken = function (refresh_token, callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.getDelegationToken = function (options, callback) {};

/**
 * @param {object|string} query
 * @return {undefined}
 */
Auth0.prototype.logout = function (query) {};

/**
 * @param {boolean} withActiveDirectories
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.getSSOData = function (withActiveDirectories, callback) {};

/**
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.getConnections = function (callback) {};

/**
 * @param {object} options
 * @param {Function} callback
 * @return {undefined}
 */
Auth0.prototype.requestSMSCode = function (options, callback) {};
