import React, { Component } from 'react';

import SearchBox from '../containers/search_box';;

export default class SearchApp extends Component {
  	render() {
	    return (
	      	 <div>
	      	 	<div className="row">
	      	 		<div className="col-lg-12 centered">
		      	 		<div className="container container-fluid page">
		      	 			<h1 className="center-title">Welcome to Ads Search </h1>
	      		 			<SearchBox />
	  		 			</div>
		 			</div>
	  		 	</div>
	  		 </div>
	    );
  	}
}
