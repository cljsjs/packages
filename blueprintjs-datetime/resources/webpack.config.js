module.exports = {
  entry: {
    'blueprintjs-datetime': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM',
  }
};
