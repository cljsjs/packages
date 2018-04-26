var path = require('path');
process.env.NODE_ENV = "production";

module.exports = {
    entry: [
        './main.js'
    ],

    externals: {
        "react": "React",
        "react-dom": "ReactDOM",
        "prop-types": "PropTypes",
        "highlight.js": "hljs"
    },

    output: {
        filename: '[name].js',
        libraryTarget: "var",
        library: "Highlight"
    },

    module: {
        loaders: [
          {
            test: /\.js$/,
            loader: 'babel-loader',
            include: path.join(__dirname, 'src')
          },
          {
            test: /\.css$/,
            loaders: ['style', 'css?modules&importLoaders=1', 'cssnext'],
            exclude: path.join(__dirname, 'node_modules')
          }
        ]
      }
}
