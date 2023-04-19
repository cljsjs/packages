var path = require('path');

module.exports = {
    entry: path.join(__dirname, "src", "index.js"),
    output: {
        path: path.join(__dirname, "dist"),
        filename: "reactcss.inc.js",
        libraryTarget: "var",
        library: "ReactCSS"
    },
    externals: {
        "react": "React",
        "loadash": "_"
    },
    module: {
        loaders: [
            {
                test: /\.jsx?$/,
                include: path.join(__dirname, 'src'),
                loader: 'babel-loader',
                query: {
                    presets: ['es2015', 'react', 'stage-0']
                }
            }
    ]
  }
};
