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
			<div className="container_header">
				<div className="row">
					<div className="col-xs-offset-3 col-md-6">
						<input type="text" className="input-lg" ref="searchText" placeholder="Search Ads here..."
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