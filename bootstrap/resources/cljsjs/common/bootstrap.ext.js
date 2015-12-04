/**
 * @fileoverview Externs for Twitter Bootstrap
 * @see http://twitter.github.com/bootstrap/
 * 
 * @author Qamal Kosim-Satyaputra
 * https://github.com/mechatama/externs/blob/master/externs/twitter-bootstrap.js
 * @externs
 */



// --- Modal ---



/** @constructor */
jQuery.modal.options = function() {};

/** @type {boolean} */
jQuery.modal.options.prototype.backdrop;

/** @type {boolean} */
jQuery.modal.options.prototype.keyboard;

/** @type {boolean} */
jQuery.modal.options.prototype.show;

/**
 * @param {=(string|jQuery.modal.options)} opt_eventOrOptions
 * @return {jQuery}
 */
jQuery.prototype.modal = function(opt_eventOrOptions) {};



// --- Dropdown ---



/**
 * @return {jQuery}
 */
jQuery.prototype.dropdown = function() {};



// --- Scroll Spy ---



/** @constructor */
jQuery.scrollspy.options = function() {};

/** @type {number} */
jQuery.scrollspy.options.prototype.offset;

/**
 * @param {=jQuery.scrollspy.options} opt_options
 * @return {jQuery}
 */
jQuery.prototype.scrollspy = function(opt_options) {};



// --- Tabs ---



/**
 * @param {=string} opt_event
 * @return {jQuery}
 */
jQuery.prototype.tab = function(opt_event) {};



// --- Tooltips ---



/** @constructor */
jQuery.tooltip.options = function() {};

/** @type {boolean} */
jQuery.tooltip.prototype.animation;

/** @type {string|function} */
jQuery.tooltip.prototype.placement;

/** @type {string} */
jQuery.tooltip.prototype.selector;

/** @type {string|function} */
jQuery.tooltip.prototype.title;

/** @type {string} */
jQuery.tooltip.prototype.trigger;

/** @type {number|{show: number, hide: number}} */
jQuery.tooltip.prototype.delay;

/**
 * @param {=(string|jQuery.tooltip.options)} opt_eventOrOptions
 * @return {jQuery}
 */
jQuery.prototype.tooltip = function(opt_eventOrOptions) {};



// --- Popovers ---



/** @constructor */
jQuery.popover.options = function() {};

/** @type {boolean} */
jQuery.popover.prototype.animation;

/** @type {string|function} */
jQuery.popover.prototype.placement;

/** @type {string} */
jQuery.popover.prototype.selector;

/** @type {string} */
jQuery.popover.prototype.trigger;

/** @type {string|function} */
jQuery.popover.prototype.title;

/** @type {string|function} */
jQuery.popover.prototype.content;

/** @type {number|{show: number, hide: number}} */
jQuery.popover.prototype.delay;

/**
 * @param {=(string|jQuery.tooltip.options)} opt_eventOrOptions
 * @return {jQuery}
 */
jQuery.prototype.popover = function(opt_eventOrOptions) {};



// --- Alerts ---



/**
 * @param {=string} opt_event
 * @return {jQuery}
 */
jQuery.prototype.alert = function(opt_event) {};



// --- Buttons ---



/**
 * @param {=string} opt_state
 * @return {jQuery}
 */
jQuery.prototype.button = function(opt_state) {};



// --- Collapse ---



/** @constructor */
jQuery.collapse.options = function() {};

/** @type {jQuerySelector} */
jQuery.collapse.options.prototype.parent;

/** @type {boolean} */
jQuery.collapse.options.prototype.toggle;

/**
 * @param {=(string|jQuery.collapse.options)} opt_eventOrOptions
 */
jQuery.prototype.collapse = function(opt_eventOrOptions) {};



// --- Carousel ---



/** @constructor */
jQuery.carousel.options = function() {};

/** @type {number} */
jQuery.carousel.options.prototype.interval;

/** @type {string} */
jQuery.carousel.options.prototype.pause;

/**
 * @param {=(string|jQuery.carousel.options})} opt_eventOrOptions
 */
jQuery.prototype.carousel = function(opt_eventOrOptions) {};



// --- Typeahead ---



/** @constructor */
jQuery.typeahead.options = function() {};

/** @type {Array} */
jQuery.typeahead.options.prototype.source;

/** @type {number} */
jQuery.typeahead.options.prototype.items;

/** @type {function} */
jQuery.typeahead.options.prototype.matcher;

/** @type {function} */
jQuery.typeahead.options.prototype.sorter;

/** @type {function} */
jQuery.typeahead.options.prototype.highlighter;

/**
 * @param {=(string|jQuery.typeahead.options)} opt_options
 * @return {jQuery}
 */
jQuery.prototype.typeahead = function(opt_options) {};

/**
 * @param {Element|jQuery|jQuerySelector}
 * @param {=jQuery.typeahead.options} opt_options
 * @return {jQuery}
 */
jQuery.prototype.typeahead.Constructor = function(element, opt_options) {};
