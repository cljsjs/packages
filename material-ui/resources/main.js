(function () {

  var materialUI = require('./build/index.js');
  var materialUIStyles = require('./build/styles/index.js');
  var withWidth = require('./build/utils/withWidth.js');
  var colorManipulator = require('./build/utils/colorManipulator.js');

  window["MaterialUI"] = materialUI;
  window["MaterialUIStyles"] = materialUIStyles;
  window["MaterialUIUtils"] = {
    withWidth : withWidth,
    colorManipulator : colorManipulator
  };
})();
