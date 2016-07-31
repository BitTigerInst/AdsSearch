import React from 'react';
import {Route, Router, IndexRoute, hashHistory} from 'react-router';
import Login from '../components/Login.jsx';
import SearchApp from '../components/SearchApp';

export default (
	<Router history={hashHistory}>
		<Route path="/">
			<IndexRoute component={SearchApp} />
		</Route>
	</Router>
);