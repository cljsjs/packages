var path = require('path');

module.exports = {
    entry: path.join(__dirname, "src", "index.js"),
    output: {
        path: path.join(__dirname, "dist"),
        filename: "react-color.inc.js",
        libraryTarget: "var",
        library: "ReactColor"
    },
    externals: {
        "react": "React",
        "../../modules/tinycolor2": "tinycolor",
        "lodash/debounce": "_.debounce",
        "lodash/each": "_.each",
        "lodash/map": "_.map",
        "lodash/throttle": "_.throttle",
        "material-colors": "materialColors",
        "prop-types": "PropTypes",
        "react": "React",
        "reactcss": "ReactCSS"
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
