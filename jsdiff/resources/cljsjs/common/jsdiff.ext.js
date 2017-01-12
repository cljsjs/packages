/**
 * @fileoverview Handwritten externs for jsdiff, based on API description in jsdiff README.md
 * @externs
 */

/** @const */
var JsDiff = {}

JsDiff.ChangeObject = function () {}

/** @type {string} */
JsDiff.Change.prototype.value;

/** @type {?boolean} */
JsDiff.Change.prototype.added;

/** @type {?boolean} */
JsDiff.Change.prototype.removed;

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffChars = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffWords = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffWordsWithSpace = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {{ignoreWhitespace: boolean, newlineIsToken: boolean}=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffLines = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffTrimmedLines = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffSentences = function(oldStr, newStr, options) {};

/**
 * @param {string} oldStr
 * @param {string} newStr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffCss = function(oldStr, newStr, options) {};

/**
 * @param {Object} oldObj
 * @param {Object} newObj
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffJson = function(oldObj, newObj, options) {};

/**
 * @param {Array} oldArr
 * @param {Array} newArr
 * @param {Object=} options
 * @return {Array<JsDiff.Change>}
 */
JsDiff.diffArrays = function(oldArr, newArr, options) {};

/**
 * @param {string} oldFileName
 * @param {string} newFileName
 * @param {string} oldStr
 * @param {string} newStr
 * @param {string} oldHeader
 * @param {string} newHeader
 * @param {{context: number}=} options
 * @return {string}
 */
JsDiff.createTwoFilesPatch = function(oldFileName, newFileName, oldStr, newStr, oldHeader, newHeader, options) {};

/**
 * @param {string} fileName
 * @param {string} oldStr
 * @param {string} newStr
 * @param {string} oldHeader
 * @param {string} newHeader
 * @param {{context: number}=} options
 * @return {string}
 */
JsDiff.createPatch = function(fileName, oldStr, newStr, oldHeader, newHeader, options) {};

JsDiff.Hunk = function () {}

/** type {number} */
JsDiff.Hunk.prototype.oldStart;

/** type {number} */
JsDiff.Hunk.prototype.newStart;

/** type {number} */
JsDiff.Hunk.prototype.oldLines;

/** type {number} */
JsDiff.Hunk.prototype.newLines;

/** type {Array<string>} */
JsDiff.Hunk.prototype.lines;

/**
 * @param {string} oldFileName
 * @param {string} newFileName
 * @param {string} oldStr
 * @param {string} newStr
 * @param {string} oldHeader
 * @param {string} newHeader
 * @param {{context: number}=} options
 * @return {{oldFileName: string, newFileName: string, oldHeader: string, newHeader: string, hunks: Array<JsDiff.Hunk>}}
 */
JsDiff.structuredPatch = function(oldFileName, newFileName, oldStr, newStr, oldHeader, newHeader, options) {};

/**
 * @param {string} source
 * @param {(string|Object)} patch
 * @param {{fuzzFactor: number, compareLine: function()}=} options
 * @return {string}
 */
JsDiff.applyPatch = function(source, patch, options) {};

/**
 * @param {string} patch
 * @param {{loadFile: function (), patched: function (), complete: function ()}} options
 */
JsDiff.applyPatches = function(patch, options) {};

/**
 * @param {Array<JsDiff.Change>} changes
 * @return {string}
 */
JsDiff.convertChangesToXML = function (changes) {};

