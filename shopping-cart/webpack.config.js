const fs = require('fs');
const path = require('path');
const webpack = require('webpack');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
	entry:[
		'babel-polyfill',
		'webpack-hot-middleware/client',
		path.join(__dirname, 'app.js')
	],
	output:{
	    path: path.join(__dirname, 'dist'),
	    filename: '[name].js',
	    chunkFilename: '[id].chunk.js',
	    publicPath: '/'
	},
	devtool: 'inline-source-map',
	devServer:{
		historyApiFallback: true,
		contentBase:path.join(__dirname, 'dist'),
		clientLogLevel: 'warning'
	},
	module:{
		rules:[
			{ test: /\.js$/, exclude: /node_modules/, use: ['babel-loader'] },
			{ test: /\.vue$/, use: ['vue-loader'] },
			{ test: /\.css$/, use: ['vue-style-loader', 'css-loader'] }
		]
	},
	resolve:{},
	plugins:[
	    new VueLoaderPlugin(),
	    new webpack.NamedModulesPlugin(),
	    new webpack.HotModuleReplacementPlugin(),
	    new webpack.NoEmitOnErrorsPlugin(),
	    new HtmlWebpackPlugin({
	      template: path.join(__dirname,'index.html')
	    }),
	    new CopyWebpackPlugin([
	      {
	        from: path.resolve(__dirname, 'public'),
	        ignore: ['.*']
	      }
	    ])
	]
};