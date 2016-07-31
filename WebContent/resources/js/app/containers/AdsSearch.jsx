import React, { Component } from 'react';
import {connect} from 'react-redux';
import actions from '../actions/actions.jsx';

class AdsSearch extends Component {
	handleChange() {
		var {dispatch} = this.props;
		var searchText = this.refs.searchText.value;
		dispatch(actions.setSearchText(searchText));
	}

	render() {
		var {dispatch, searchText} = this.props;

		return (
			<div className="container container-fluid">
				<div className="row">
					<div className="col-lg-12">
						<input type="search" ref="searchText" placeholder="Search Ads here..."
							onChange={ (e) => {this.handleChange}}	/>
					</div>	
				</div>
			</div>
		)
	}

};

export default connect(
	(state) => {
		return {
			searchText: state.searchText
		};
	}
)(AdsSearch)