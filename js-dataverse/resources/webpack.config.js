module.exports = {
  entry: {
    'js-dataverse': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'axios': "axios"
  }
};
