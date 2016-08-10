import { SEARCH_ADS } from '../actions/actions';

export default function(state = [], action) {
	switch (action.type) {
		case SEARCH_ADS: {
			return action.payload.data.data.ads;
		}
	}
	return state;
}