import React, { Component } from 'react';
import { connect } from 'react-redux';

class AdDetail extends Component {
	render() {
		if (!this.props.selectedAd) {
			return <div>Search ads by typing in some keywords</div>
		}

		return (
			<div>
				<h3>Details for:</h3>
				<div></div>
			</div>
		);
	}
}

function mapStateToProps(state) {
	return {
		selectedAd: state.selectedAd
	};
}

export default connect(mapStateToProps)(AdDetail);