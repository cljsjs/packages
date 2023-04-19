var webpack = require("webpack");
var isProduction = process.env.NODE_ENV === 'production'
var entryPath = "./lib/React3.js";
var entryName = "react-three-renderer";
var output = {
  filename: '[name].inc.js',
  libraryTarget: 'umd',
  library: 'React3'
};
var externals = {
    "react": "React",
    "react-dom": "ReactDOM",
    "three": "THREE"
};

var entry = {};
if (isProduction) {
  entryName = entryName + ".min";
}
entry[entryName] = entryPath;

module.exports = {
  entry : entry,
  output: output,
  externals: externals,
  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        'NODE_ENV': isProduction ? '"production"' : '"development"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      include: /\.min\.inc\.js$/,
      minimize: true
    })
  ]
};
