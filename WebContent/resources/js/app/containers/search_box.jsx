import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { searchAds } from '../actions/actions'

class SearchBox extends Component {
	constructor(props) {
		super(props);

		this.state = {
			searchText: ''
		};

		this.onInputChange = this.onInputChange.bind(this);
	}

	onInputChange(searchText) {
		this.setState({
			searchText: searchText
		});
	}

	render() {
		return (
			<div className="container_header">
				<form onSubmit={this.onFormSubmit} className="input-group">
					<input 
						type="text"
						className="form-control"
						placeholder="Search Ads here..."
						value={this.state.searchText}
						onChange={this.onInputChange} />
					<span className="input-group-btn">
						<button type="submit" className="btn btn-secondary">Search!</button>
					</span>
				</form>
			</div>
		)
	}
};

function mapDispatchToProps(dispatch) {
	return bindActionCreators({searchAds}, dispatch);
}

export default connect(null, mapDispatchToProps)(SearchBox);