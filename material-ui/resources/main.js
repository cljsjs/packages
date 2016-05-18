(function () {
    var React = require('react/lib/ReactUMDEntry');
    var injectTapEventPlugin = require("react-tap-event-plugin");
    var materialUI = require('./src/index.js');
    var materialUIStyles = require('./src/styles/index.js');

    injectTapEventPlugin();

    window["React"] = React;
    window["MaterialUI"] = materialUI;
    window["MaterialUIStyles"] = materialUIStyles;
})();
