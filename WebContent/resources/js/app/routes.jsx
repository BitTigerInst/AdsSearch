import React from 'react';
import { Route, Router, IndexRoute, hashHistory } from 'react-router';

import SearchApp from './components/SearchApp';

export default (
	<Router history={hashHistory}>
		<Route path="/AdsSearch">
			<IndexRoute component={SearchApp} />
		</Route>
	</Router>
);