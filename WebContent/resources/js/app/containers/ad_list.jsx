import React, { Component } from 'react';
import { connect } from 'react-redux';
import uuid from 'uuid';

class AdList extends Component {

	renderAd(ad) {
		console.log(this.props);
		return (
			<tr key = {ad.id}>
				<td>{ad.rankScore}</td>
				<td>{ad.adId}</td>
				<td>{ad.content}</td>
				<td><a>{ad.url}</a></td>
				<td>{`${ad.tokens.toString()}&size=${this.props.size}`}</td>
				<td>{ad.bid}</td>
				<td>{ad.relevanceScore}</td>
				<td>{ad.qualityScore}</td>
			</tr>
		)
	}

	render() {
		console.log(this.props.size);
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
	return {
		ads: ads,
		size: ads.length
	}
}

export default connect(mapStateToProps)(AdList);