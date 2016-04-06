/** @const */
var commonmark = {};

commonmark.Node = function() {};

/** @type {string} */
commonmark.Node.prototype.type;

/** @type {commonmark.Node|null} */
commonmark.Node.prototype.firstChild;

/** @type {commonmark.Node|null} */
commonmark.Node.prototype.lastChild;

/** @type {commonmark.Node|null} */
commonmark.Node.prototype.next;

/** @type {commonmark.Node|null} */
commonmark.Node.prototype.prev;

/** @type {commonmark.Node|null} */
commonmark.Node.prototype.parent;

/** @type {Array} */
commonmark.Node.prototype.sourcepos;

/** @type {boolean} */
commonmark.Node.prototype.isContainer;

/** @type {string|null} */
commonmark.Node.prototype.literal;

/** @type {string|null} */
commonmark.Node.prototype.info;

/** @type {number|null} */
commonmark.Node.prototype.level;

/** @type {string|null} */
commonmark.Node.prototype.listType;

/** @type {boolean|null} */
commonmark.Node.prototype.listTight;

/** @type {number|null} */
commonmark.Node.prototype.listStart;

/** @type {string|null} */
commonmark.Node.prototype.listDelimiter;

/** @param {commonmark.Node} node */
commonmark.Node.prototype.appendChild = function(node) {};

/** @param {commonmark.Node} node */
commonmark.Node.prototype.prependChild = function(node) {};

commonmark.Node.prototype.unlink = function() {};

commonmark.Node.prototype.insertAfter = function() {};

commonmark.Node.prototype.insertBefore = function() {};

/** @return {commonmark.NodeWalker} */
commonmark.Node.prototype.walker = function() {};

commonmark.NodeWalker = function() {};

/** @return {commonmark.NodeWalkerEvent} */
commonmark.NodeWalker.prototype.next = function() {};

/**
  * @param {commonmark.Node} node
  * @param {boolean} entering
  */
commonmark.NodeWalker.prototype.resumeAt = function(node, entering) {};

commonmark.NodeWalkerEvent = function() {};

/** @type {boolean} */
commonmark.NodeWalkerEvent.prototype.entering;

/** @type {commonmark.Node} */
commonmark.NodeWalkerEvent.prototype.node;

/**
 * @param {{sourcepos: boolean, smart: boolean, safe: boolean}|null|undefined} opts
 */
commonmark.Parser = function(opts) {};

/**
 * Parses the string and returns the root node of a markdown AST.
 * @param {string} str
 * @return {commonmark.Node}
 */
commonmark.Parser.prototype.parse = function(str) {};

/**
 * @param {{sourcepos: boolean, smart: boolean, safe: boolean}|null|undefined} opts
 */
commonmark.HtmlRenderer = function(opts) {};

/**
 * @param {commonmark.Node} node
 * @return {string}
 */
commonmark.HtmlRenderer.prototype.render = function(node) {};

/**
 * @param {{sourcepos: boolean, smart: boolean, safe: boolean}|null|undefined} opts
 */
commonmark.XmlRenderer = function(opts) {};

/**
 * @param {commonmark.Node} node
 * @return {string}
 */
commonmark.XmlRenderer.prototype.render = function(node) {};
