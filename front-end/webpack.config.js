const path = require('path');
const MinifyPlugin = require('babel-minify-webpack-plugin');
const HtmlPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    devtool: 'source-map',
    context: path.resolve(__dirname, 'source'),
    entry: './index.js',
    output: {
        filename: "bundle.js",
        path: path.resolve(__dirname, './../src/main/resources/static/')
    },
    module: {
        rules: [
            {
                test: /.(js|jsx)$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            },
            {
                test: /\.(html)$/, loader: "raw-loader"
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'ng-annotate-loader',
                    options: {
                        ngAnnotate: 'ng-annotate-patched',
                        es6: true,
                        explicitOnly: false
                    }
                }],
            },
        ]
    },
    plugins: [
        new MinifyPlugin({}, {
            comments: false
        }),
        new HtmlPlugin({template: './index.html'})
    ],
    devServer: {
        publicPath: '/',
        port: 8081,
        proxy: {
            '/contacts': {
                target: 'http://localhost:8080'
            }
        }
    }
}