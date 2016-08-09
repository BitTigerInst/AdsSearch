import { SEARCH_ADS } from '../actions/actions';

export default function(state = null, action) {
	switch (action.type) {
		case SEARCH_ADS: {
			return action.payload.data.ads;
		}
	}
	return state;
}