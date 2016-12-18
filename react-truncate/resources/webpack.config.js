var path = require('path');

module.exports = {
  entry: './lib/Truncate.js',
  output: {
    path: path.join(__dirname, "dist"),
    filename: "react-truncate.inc.js",
    libraryTarget: "var",
    library: "ReactTruncate"
  },
  externals: {
    "react": "React"
  }
};
