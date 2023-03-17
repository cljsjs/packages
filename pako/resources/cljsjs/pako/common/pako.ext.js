
/**
 * @fileoverview Closure Compiler externs for pako 2.0.4.
 * @see https://github.com/nodeca/pako
 * @see http://nodeca.github.io/pako/
 * @externs
 */

/**
 * @type {Object}
 */
var pako;

/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.deflate = function(data, options) {};


/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.deflateRaw = function (data, options) {};

/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.gzip = function (data, options) {};

/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.inflate = function (data, options) {};


/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.inflateRaw = function (data, options) {};

/**
 * @param {Uint8Array|Array|String} data
 * @param {Object} options
 * @return {Uint8Array|Array|String}
 */
pako.ungzip = function (data, options) {};
