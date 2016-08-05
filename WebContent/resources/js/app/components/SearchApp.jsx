import React, { Component } from 'react';
import { createStore, applyMiddleware} from 'redux';
import AdsSearch from '../containers/AdsSearch';
import RootReducer from '../reducers/reducers.jsx';
import {connect, Provider} from 'react-redux';
import axios from 'axios';
import $ from 'jQuery';

const createStoreWithMiddleware = applyMiddleware()(createStore);

export default class SearchApp extends Component {
	constructor(props) {
		super(props);

		this.state = {
			ads: [],
			tokens: '',
			userId: -1
		}
	}

	search(tokens) {
		var url = "/AdsSearch/search"
		var param = {
			tokens: tokens
		};

		$.get(url, param, (response) => {
			console.log(response);
		});
	}

  	render() {
	    return (
	      <Provider store={createStoreWithMiddleware(RootReducer)}>
	      	 <div>
	      	 	<h1 className="center-title">Search Ads</h1>
	      	 	<div className="row">
	      	 		<div className="col-lg-12 centered">
		      	 		<div className="container container-fluid page">
	      		 			<AdsSearch onSearchTokenChange={token => this.search(token)}/>
	  		 			</div>
  		 			</div>
      		 	</div>
      		 </div>
	      </Provider>
	    );
  	}
}
