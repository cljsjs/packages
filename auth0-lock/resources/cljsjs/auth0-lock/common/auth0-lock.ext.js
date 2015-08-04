/**
 * @externs
 */

/**
 * @param {Object} options
 * @constructor
 */
var Auth0 = function (options) {};

/**
 * @type {string}
 */
Auth0.version;

/**
 * @param {string} id_token
 * @param {function} callback
 * @return {undefined}
 */
Auth0.prototype.getProfile = function (id_token, callback) {};

/**
 * @param {String} clientID
 * @param {String} domain
 * @param {Object} options
 *     - cdn
 *     - assetsUrl
 * @return {Auth0Lock}
 * @constructor
 */
var Auth0Lock = function (clientID, domain, options) {};


/**
 * @type {string}
 */
Auth0Lock.version;


Auth0Lock.prototype.showNetworkError = function () {};

/**
 * @param {String} selector
 * @param {NodeElement} context
 * @return {BonzoAugmented}
 * @public
 */
Auth0Lock.prototype.query = function (selector, context) {};

/**
 * @param {Function} tmpl
 * @param {Object} locals
 * @return {String}
 * @public
 */
Auth0Lock.prototype.render = function (tmpl, locals) {};

/**
 * @param {Object} options
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.show = function (options, callback) {};

/**
 * @param {Object} options
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.showSignin = function (options, callback) {};

/**
 * @param {Object} options
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.showSignup = function (options, callback) {};

/**
 * @param {Object} options
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.showReset = function (options, callback) {};

/**
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.hide = function (callback) {};

/**
 * @param {Object} query
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.logout = function (query) {};

/**
 * @return {Auth0}
 * @public
 */

Auth0Lock.prototype.getClient = function () {};

/**
 * @param {String} hash
 * @return {Object|Error}
 * @public
 */

Auth0Lock.prototype.parseHash = function (hash) {};

/**
 * @param {String} token
 * @param {Function} callback
 * @return {Auth0Lock}
 * @public
 */
Auth0Lock.prototype.getProfile = function (token, callback) {};

/**
 * @param {String} panelName
 * @public
 */
Auth0Lock.prototype._setPreviousPanel = function (panelName) {};

/**
 * @return {String}
 * @public
 */
Auth0Lock.prototype._getPreviousPanel = function () {};

/**
 * @public
 */
Auth0Lock.prototype._clearPreviousPanel = function () {};



