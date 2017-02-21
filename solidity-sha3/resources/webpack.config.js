var path = require('path');

module.exports = {
  entry: './main.js',
  output: {
    path: path.join(__dirname, "dist"),
    filename: "solidity-sha3.inc.js",
    libraryTarget: "var",
    library: "SoliditySha3"
  },
  externals: {
    "web3": "Web3"
  },
  devtool: 'source-map'
};
