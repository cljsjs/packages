var PropTypes = {};

/**
 * @typedef {function(boolean, boolean, Object, string, string, string): boolean} PropTypes.ChainableTypeChecker
 */
PropTypes.ChainableTypeChecker;

/**
 * @type {PropTypes.ChainableTypeChecker}
 */
PropTypes.ChainableTypeChecker.weak;

/**
 * @type {PropTypes.ChainableTypeChecker}
 */
PropTypes.ChainableTypeChecker.weak.isRequired;

/**
 * @type {PropTypes.ChainableTypeChecker}
 */
PropTypes.ChainableTypeChecker.isRequired;

/**
 * @type {PropTypes.ChainableTypeChecker}
 */
PropTypes.ChainableTypeChecker.isRequired.weak;

/**
 * @type {Object}
 */
PropTypes.ReactPropTypes = {
  /** @type {PropTypes.ChainableTypeChecker} */
  any: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  array: function() {},
  /**
   * @param {PropTypes.ChainableTypeChecker} typeChecker
   * @return {PropTypes.ChainableTypeChecker}
   */
  arrayOf: function(typeChecker) {},
  /** @type {PropTypes.ChainableTypeChecker} */
  bool: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  component: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  element: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  func: function() {},
  /**
   * @param {function (new:Object, ...*): ?} expectedClass
   * @return {PropTypes.ChainableTypeChecker}
   */
  instanceOf: function(expectedClass) {},
  /** @type {PropTypes.ChainableTypeChecker} */
  node: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  number: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  object: function() {},
  /**
   * @param {PropTypes.ChainableTypeChecker} typeChecker
   * @return {PropTypes.ChainableTypeChecker}
   */
  objectOf: function(typeChecker) {},
  /**
   * @param {Array.<*>} expectedValues
   * @return {PropTypes.ChainableTypeChecker}
   */
  oneOf: function(expectedValues) {},
  /**
   * @param {Array.<PropTypes.ChainableTypeChecker>} typeCheckers
   * @return {PropTypes.ChainableTypeChecker}
   */
  oneOfType: function(typeCheckers) {},
  /** @type {PropTypes.ChainableTypeChecker} */
  renderable: function() {},
  /** @type {PropTypes.ChainableTypeChecker} */
  /**
   * @param {Object.<PropTypes.ChainableTypeChecker>} shapeTypes
   * @return {PropTypes.ChainableTypeChecker}
   */
  shape: function(shapeTypes) {},
  /** @type {PropTypes.ChainableTypeChecker} */
  string: function() {}
};
