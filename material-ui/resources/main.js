(function () {

  var React = require('react/lib/ReactWithAddonsUMDEntry');
  var ReactDOM = require('react-dom/lib/ReactDOM.js');
  var injectTapEventPlugin = require("react-tap-event-plugin");
  var materialUI = require('./build/index.js');
  var materialUIStyles = require('./build/styles/index.js');
  var withWidth = require('./build/utils/withWidth.js');
  var colorManipulator = require('./build/utils/colorManipulator.js');

  window["React"] = React;
  window["ReactDOM"] = ReactDOM;
  window["MaterialUI"] = materialUI;
  window["MaterialUIStyles"] = materialUIStyles;
  window["MaterialUIUtils"] = {
    withWidth : withWidth,
    colorManipulator : colorManipulator
  };
  injectTapEventPlugin();
})();
