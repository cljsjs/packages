var path = require('path');

module.exports = {
  entry: './src/react-ultimate-pagination.js',
  output: {
    path: path.join(__dirname, "dist"),
    filename: "react-ultimate-pagination.inc.js",
    libraryTarget: "var",
    library: "ReactUltimatePagination"
  },
  externals: {
    "react": "React"
  },
  devtool: 'source-map',
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015', 'react']
        }
      }
    ]
  }
};
