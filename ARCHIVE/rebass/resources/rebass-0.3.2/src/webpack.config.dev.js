var path = require("path")

module.exports = {
  entry: path.join(__dirname, "./entry.js"),

  output: {
    path: __dirname,
    filename: "bundle-dev.js",
    library: "Rebass"
  },

  externals: {"react": "React"},

  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders: [
          "babel"
        ]
      },
    ]
  },
}

