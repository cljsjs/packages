var webpack = require("webpack");
var svgIcons = process.argv.indexOf('--svg-icons') !== -1;
var entryPath = "./lib/index.js";
var entryName = "material-ui";
var library = "MaterialUI";

if (svgIcons) {
    entryPath =  "./lib/svg-icons/index.js";
    entryName = "material-ui-svg-icons";
    library = "MaterialUISvgIcons";
}

var entryNameMin = entryName + ".min";
var entry = {};
entry[entryName] = entryPath;
entry[entryNameMin] = entryPath;

module.exports = {
  entry : entry,
  output: {
    filename: '[name].inc.js',
    libraryTarget: "var",
    library: library
  },
  externals: {
              "react": "React",
              "react-dom": "ReactDOM",
              "./React": "React"
  },
  plugins: [
    new webpack.optimize.UglifyJsPlugin({
      include: /\.min\.inc\.js$/,
      minimize: true
    })
  ]
};
