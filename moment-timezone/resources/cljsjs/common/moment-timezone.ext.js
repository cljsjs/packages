"use strict";

/**
 * @fileoverview Externs for moment-timezone.js 0.5.10
 * @externs
 */

/**
 * @interface
 */
function Moment() {};

/**
 * @nosideeffects
 * @type {(function():!Moment|function(!Date):!Moment|function(!number):!Moment|function(!Array.<!number>):!Moment|function(!string, !(string|Array.<!string>)=):!Moment|function(!Moment):!Moment)}
 */
function moment() {};

/**
 * @since 0.0.1
 * @type {(function():!Moment|function(!Date, !string):!Moment|function(!number, !string):!Moment|function(!Array.<!number>, !string):!Moment|function(!string, !(string|Array.<!string>)=):!Moment|function(!Moment, !string):!Moment)}
 */
Moment.prototype.tz = function() {};
