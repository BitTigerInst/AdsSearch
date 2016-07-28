import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import {Route, Router, IndexRoute, hashHistory} from 'react-router';
import HelloWorld from './components/HelloWorld.jsx';

// Load foundation
require('style!css!foundation-sites/dist/foundation.min.css');
$(document).foundation();

//App css
require('style!css!sass!applicationStyles')

class App extends Component {
	render() {
		return (
			<div>
				<HelloWorld />
				<p>Hi</p>
			</div>
		);
	}
}

ReactDOM.render(<App />, document.querySelector('#app'));