import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import {Route, Router, IndexRoute, hashHistory} from 'react-router';
import router from './router/router.jsx'

//App css
require('style!css!sass!applicationStyles')

class App extends Component {
	render() {
		return (
			<div>
				{router}
			</div>
		);
	}
}

ReactDOM.render(<App />, document.querySelector('#app'));