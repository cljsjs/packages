/**
 * @fileoverview Closure Compiler externs for Facebook ReactDOM.js DOM 0.14.0-rc1
 * @see http://reactjs.org
 * @externs
 */

/**
 * @type {Object}
 * @const
 */
var ReactDOM = {};

/**
 * @type {string}
 */
ReactDOM.version;

/**
 * @param {ReactDOM.ReactDOMComponent} container
 * @param {Element} mountPoint
 * @param {Function=} callback
 * @return {ReactDOM.ReactDOMComponent}
 */
ReactDOM.render = function(container, mountPoint, callback) {};


/**
 * @param {Element} container
 */
ReactDOM.unmountComponentAtNode = function(container) {};

ReactDOM.findDOMNode = function(component) {};
