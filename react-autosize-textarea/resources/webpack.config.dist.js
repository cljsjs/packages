var webpack = require('webpack');

module.exports = {
    entry: './src/index.ts',
    module: {
        loaders: [
            {
                test: /\.tsx?$/,
                loader: 'ts-loader',
                exclude: /node_modules/
            },
        ]
    },
    externals: {
        'react': 'React',
        'react-dom': 'ReactDOM',
    },
    output: {
        filename: 'dist/react-autosize-textarea.js',
        libraryTarget: 'umd',
        library: 'TextareaAutosize'
    },
    resolve: {
        extensions: ['.tsx', '.ts', '.js']
    }
};
