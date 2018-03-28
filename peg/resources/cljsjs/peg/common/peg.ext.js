/**
 * @fileoverview Closure Compiler externs for peg.js 0.8.0
 * @see http://pegjs.org
 * @externs
 */

/* Bare minimum */

var PEG = {};

PEG.buildParser = function(grammar) { return { parse: function(input){} }; };
