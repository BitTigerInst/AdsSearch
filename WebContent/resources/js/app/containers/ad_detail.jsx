import React, { Component } from 'react';
import { connect } from 'react-redux';

class AdDetail extends Component {
	render() {
		if (!this.props.ad) {
			return <div>Search ads by typing in some keywords</div>
		}

		var ad = this.props.ad;
		return (
			<div>
				<h3>{`Details for Ad: ${ad.adId}`}</h3>
				<ul className="list-group">	
					<li className="list-group-item list-group-item-success">{`Ad Id: ${ad.adId}`}</li>
					<li className="list-group-item list-group-item-info">{`Ad Ranking: ${ad.rankScore.toFixed(2)}`}</li>
					<li className="list-group-item list-group-item-warning">{`Content: ${ad.content}`}</li>
					<li className="list-group-item list-group-item-success">{`Ad Url: ${ad.url}`}</li>
					<li className="list-group-item list-group-item-danger">{`Ad RelevanceScore: ${ad.relevanceScore.toFixed(2)}`}</li>
					<li className="list-group-item list-group-item-info" >{`Ad QualityScore: ${ad.qualityScore.toFixed(2)}`}</li>
				</ul>
			</div>
		);
	}
}

function mapStateToProps(state) {
	return {
		ad: state.selectedAd
	};
}

export default connect(mapStateToProps)(AdDetail);