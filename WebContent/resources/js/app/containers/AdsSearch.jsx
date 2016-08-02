import React, { Component } from 'react';
import {connect} from 'react-redux';
import actions from '../actions/actions.jsx';

class AdsSearch extends Component {
	constructor(props) {
		super(props);

		this.state = {token: ''};
	}

	render() {
		var {dispatch, searchText} = this.props;

		return (
			<div className="container_header">
				<div className="row">
					<div className="col-xs-offset-3 col-md-6">
						<input type="text" className="input-lg" ref="searchText" placeholder="Search Ads here..."
							onChange={(event) => this.onInputChange(event.target.value)}/>
					</div>	
				</div>
			</div>
		)
	}

	onInputChange(token) {
		this.setState({
			token: token
		});
		this.props.onSearchTokenChange(token);
	}

};

export default connect(
	(state) => {
		return {
			searchText: state.searchText
		};
	}
)(AdsSearch)