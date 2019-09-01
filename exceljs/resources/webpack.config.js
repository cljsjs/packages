module.exports = {
  entry: {
    'exceljs': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  node: {
    fs: "empty"
  }
};
