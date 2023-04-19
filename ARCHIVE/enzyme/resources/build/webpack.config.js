const path = require("path");
const webpack = require("webpack");

module.exports = {
  entry: [path.join(__dirname, "node_modules", "enzyme", "build", "index.js"),
          path.join(__dirname, "helper.js")],
  output: {
    filename: "enzyme.bundled.js"
  },
  externals: {
    "react/addons": true,
    "react/lib/ExecutionEnvironment": true,
    "react/lib/ReactContext": true,
    "react-addons-test-utils": "react-dom"
  }
};
