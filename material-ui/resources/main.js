(function () {

  var React = require('react/lib/ReactWithAddonsUMDEntry');
  var injectTapEventPlugin = require("react-tap-event-plugin");
  var materialUI = require('./build/index.js');
  var materialUIStyles = require('./build/styles/index.js');

  window["React"] = React;
  window["MaterialUI"] = materialUI;
  window["MaterialUIStyles"] = materialUIStyles;

  injectTapEventPlugin();
})();
