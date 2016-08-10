import React, { Component } from 'react';
import { connect } from 'react-redux';
import uuid from 'uuid';

class AdList extends Component {
	renderAd(ad) {
		return (
			<tr key = {ad.id}>
				<td>{ad.title}</td>
				<td>{ad.CompanyName}</td>
				<td>{ad.content}</td>
			</tr>
		)
	}

	render() {
		return (
			<div>
				<table className="table table-hover">
					<thead>
						<tr>
							<th>Title</th>
							<th>CompanyName</th>
							<th>Content</th>
						</tr>
					</thead>
					<tbody>
						{this.props.ads.map(this.renderAd)}
					</tbody>
				</table>
			</div>
		);
	}
}

function mapStateToProps({ ads }) {
	return { ads }; 
}

export default connect(mapStateToProps)(AdList);