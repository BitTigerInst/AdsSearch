import React, { Component } from 'react';
import { connect } from 'react-redux';
import uuid from 'uuid';

class AdList extends Component {
	renderAd(ad) {
		return (
			<tr key = {ad.id}>
				<td>{ad.rankScore}</td>
				<td>{ad.adId}</td>
				<td>{ad.content}</td>
				<td><a>{ad.url}</a></td>
				<td>{ad.tokens}</td>
				<td>{ad.bid}</td>
				<td>{ad.relevanceScore}</td>
				<td>{ad.qualityScore}</td>
			</tr>
		)
	}

	render() {
		return (
			<div>
				<table className="table table-hover">
					<thead>
						<tr>
							<th>Rank Score</th>
							<th>Ad Id</th>
							<th>Content</th>
							<th>Url</th>
							<th>Keywords</th>
							<th>Bid</th>
							<th>Relevance Score</th>
							<th>Quality Score</th>
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