module.exports = {
    entry: {
        'react-leaflet': './main.js'
    },
    output: {
        filename: '[name].inc.js'
    },
    externals: {
        'react': 'React',
        'react-dom': 'ReactDOM',
        'leaflet': 'L'
    }
};
