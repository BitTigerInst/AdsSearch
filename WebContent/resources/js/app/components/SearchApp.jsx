import React, { Component } from 'react';
import { createStore, applyMiddleware} from 'redux';
import AdsSearch from '../containers/AdsSearch';
import RootReducer from '../reducers/reducers.jsx';
import {connect, Provider} from 'react-redux';

const createStoreWithMiddleware = applyMiddleware()(createStore);

export default class SearchApp extends Component {
  	render() {
	    return (
	      <Provider store={createStoreWithMiddleware(RootReducer)}>
	      	 <div>
	      	 	<h1 className="center-title">Search Ads</h1>
	      	 	<div className="row">
	      	 		<div className="col-lg-12 centered">
		      	 		<div className="container container-fluid page">
	      		 			<AdsSearch />
	  		 			</div>
  		 			</div>
      		 	</div>
      		 </div>
	      </Provider>
	    );
  	}
}
