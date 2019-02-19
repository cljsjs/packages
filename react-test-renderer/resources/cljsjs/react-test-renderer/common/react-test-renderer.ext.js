/**
 * @type {!Object}
 * @const
 * @suppress {const|duplicate}
 */
var ReactTestRenderer = {};

/**
 * @return {ReactTestRenderer.Interface}
 */
ReactTestRenderer.create = function() {};

/**
 * @interface
 */
ReactTestRenderer.Interface = function() {};

/**
 * @type {ReactTestRenderer.Instance}
 */
ReactTestRenderer.Interface.root;

/**
 * @return {Object}
 */
ReactTestRenderer.Interface.toJSON = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Interface.toTree = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Interface.update = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Interface.unmount = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Interface.getInstance = function() {};

/**
 * @interface
 */
ReactTestRenderer.Instance = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.find = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.findByType = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.findByProps = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.findAll = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.findAllByType = function() {};

/**
 * @return {Object}
 */
ReactTestRenderer.Instance.findAllByProps = function() {};

/**
 * @type {Object}
 */
ReactTestRenderer.Instance.instance;

/**
 * @type {Object}
 */
ReactTestRenderer.Instance.type;

/**
 * @type {Object}
 */
ReactTestRenderer.Instance.props;

/**
 * @type {Object}
 */
ReactTestRenderer.Instance.parent;

/**
 * @type {Object}
 */
ReactTestRenderer.Instance.children;

