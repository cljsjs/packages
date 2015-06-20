/**
 * @constructor
 */
var JSZip = function() {};

/**
 * @constructor
 */
var ZipObject = function() {};

/**
 * @param  {string|ArrayBuffer|Uint8Array|Buffer} data
 * @param  {Object=} options
 * @return {JSZip}
 */
JSZip.prototype.load = function(data, options) {};

/**
 * @param  {string|RegExp} name
 * @param  {string|ArrayBuffer|Uint8Array|Buffer=} data
 * @param  {Object=} options
 * @return {ZipObject|Array.<ZipObject>|JSZip}
 */
JSZip.prototype.file = function(name, data, options) {};

/**
 * @param  {string|RegExp} name
 * @return {JSZip|Array.<ZipObject>}
 */
JSZip.prototype.folder = function(name) {};

/**
 * @param  {Function} predicate
 * @return {Array.<ZipObject>}
 */
JSZip.prototype.filter = function(predicate) {};

/**
 * @param  {string} name
 * @return {JSZip}
 */
JSZip.prototype.remove = function(predicate) {};

/**
 * @param  {Object} options
 * @return {string|Uint8Array|ArrayBuffer|Blob|Buffer}
 */
JSZip.prototype.generate = function(options) {};
