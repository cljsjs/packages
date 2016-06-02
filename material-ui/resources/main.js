(function () {

  var React = require('react');
  var ReactDOM = require('react-dom');
  var ReactDOMServer = require('react-dom/server');
  var injectTapEventPlugin = require("react-tap-event-plugin");
  var materialUI = require('./build/index.js');
  var materialUIStyles = require('./build/styles/index.js');

  window["React"] = React;
  window["ReactDOM"] = ReactDOM;
  window["ReactDOMServer"] = ReactDOMServer;
  window["MaterialUI"] = materialUI;
  window["MaterialUIStyles"] = materialUIStyles;

  injectTapEventPlugin();
})();
