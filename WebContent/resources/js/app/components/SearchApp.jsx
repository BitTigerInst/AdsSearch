import React, { Component } from 'react';

import SearchBox from '../containers/search_box';
import AdList from '../containers/ad_list';
import AdDetail from '../containers/ad_detail'

export default class SearchApp extends Component {
  	render() {
	    return (
	      	 <div>
	      	 	<div className="row">
	      	 		<div className="col-lg-12 centered">
		      	 		<div className="container container-fluid page">
		      	 			<nav className="navbar navbar-inverse">
		      	 				<a className="navbar-brand" href="#">Welcome to Ads Search </a>
		      	 			</nav>
	      		 			<SearchBox />
	      		 			<AdDetail />
      		 				<AdList />
	  		 			</div>
		 			</div>
	  		 	</div>
	  		 </div>
	    );
  	}
}
