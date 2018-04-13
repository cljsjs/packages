var path = require('path');

module.exports = {
  entry: './lib/index.js',
  output: {
    path: path.join(__dirname, "dist"),
    filename: "react-sticky.inc.js",
    libraryTarget: "var",
    library: "ReactSticky"
  },
  externals: {
    "react": "React",
    "react-dom": "ReactDOM",
    "prop-types": "PropTypes"
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      }
    ]
  }
};
