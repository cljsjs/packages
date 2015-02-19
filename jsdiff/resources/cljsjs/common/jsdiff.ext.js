
var JsDiff = {
  diffChars: function(oldStr, newStr, callback) {},
  diffWords: function(oldStr, newStr, callback) {},
  diffWordsWithSpace: function(oldStr, newStr, callback) {},
  diffLines: function(oldStr, newStr, callback) {},
  diffSentences: function(oldStr, newStr, callback) {},
  diffCss: function(oldStr, newStr, callback) {},
  diffJson: function(oldObj, newObj, callback) {},
  createPatch: function(fileName, oldStr, newStr, oldHeader, newHeader) {},
  applyPatch: function(oldStr, uniDiff) {},
  convertChangesToXML: function(changes) {},
  convertChangesToDMP: function(changes) {},
  canonicalize: function(obj, stack, replacementStack) {}
};

JsDiff.Diff = function(ignoreWhitespace) {};
JsDiff.Diff.prototype = {
  diff: function(oldString, newString, callback) {},
  pushComponent: function(components, added, removed) {},
  extractCommon: function(basePath, newString, oldString, diagonalPath) {},
  equals: function(left, right) {},
  tokenize: function(value) {}
};
