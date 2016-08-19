import React, { Component } from 'react';
import { connect } from 'react-redux';
import { selectAd } from '../actions/actions'
import uuid from 'uuid';
import { bindActionCreators } from 'redux';

class AdList extends Component {

	renderAds() {
		return this.props.ads.map((ad) => {
			return (
				<tr className="clickable-row" key = {ad.id} onClick={() => 
					{
						this.props.selectAd(ad)
					}}>
					<td>{ad.rankScore}</td>
					<td>{ad.adId}</td>
					<td>{ad.content}</td>
					<td>{ad.url}</td>
					<td>{ad.tokens.toString()}</td>
				</tr>
			)
		})
	}

	render() {
		this.count = 0;
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
						</tr>
					</thead>
					<tbody>
					   {this.renderAds()}
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

function mapDispatchToProps(dispatch) {
	return bindActionCreators({selectAd: selectAd}, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(AdList);