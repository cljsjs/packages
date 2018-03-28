var path = require('path');

module.exports = {
  entry: './main.js',
  output: {
    path: path.join(__dirname, "dist"),
    filename: "material-ui-chip-input.inc.js",
    libraryTarget: "var",
    library: "MaterialUIChipInput"
  },
  externals: {
    "react": "React",
    "material-ui/Chip": "MaterialUI.Chip",
    "material-ui/styles/colors": "MaterialUIStyles.colors",
    "material-ui/styles/transitions": "MaterialUIStyles.transitions",
    "material-ui/AutoComplete/AutoComplete": "MaterialUI.AutoComplete",
    "material-ui/utils/colorManipulator": "MaterialUIUtils.colorManipulator"
  },
  devtool: 'source-map',
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015', 'react', 'stage-0']
        }
      }
    ]
  }
};
