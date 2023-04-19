const path = require('path');
const webpack = require('webpack');

module.exports = function(env) {
    var isProd = env && env.production;

    return {
      entry: path.join(__dirname, "src", "index.js"),
        output: {
            filename: isProd ? "dataloader.min.inc.js" : "dataloader.inc.js",
            libraryTarget: "var",
            library: "DataLoader"
        },
        mode: isProd ? "production" : "development",
        module: {
          rules: [
            {
              test: /\.js$/,
              exclude: /(node_modules|bower_components)/,
              use: {
                loader: 'babel-loader',
                options: {
                  presets: ["es2015", "stage-0"]
                }
              }
            }
          ]
        }
    }
};

