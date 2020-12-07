const path = require('path');
const MinifyPlugin = require('babel-minify-webpack-plugin');
const HtmlPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    // mode: 'production',
    devtool: 'source-map',
    context: path.resolve(__dirname, 'source'),
    entry: './main.js',
    output: {
        filename: "index.js",
        path: path.resolve(__dirname, 'assets')
    },
    module: {
        rules: [
            {
                test: /.(js|jsx)$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            }
        ]
    },
    plugins: [
        new MinifyPlugin({}, {
            comments: false
        }),
        new HtmlPlugin({template: './../index.html'})
    ]
}