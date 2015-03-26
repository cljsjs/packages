/**
 * @fileoverview Externs for Heap.js
 *
 * @see https://heapanalytics.com/docs/custom-api
 * @externs
 */

/** @const */
var heap = {};

heap.userid;

/**
 * @param {Object} o
 */
heap.identify = function(o) { };

/**
 * @param {string} s
 * @param {Object} o
 */
heap.track = function(s,o) {};

/**
 * @param {Object} o
 */
heap.setEventProperties = function(o) { };

/**
 * @param {string} s
 */
heap.unsetEventProperties = function(s) { };

heap.clearEventProperties = function() { };
