import { SEARCH_ADS } from '../actions/actions';

export default function(state = [], action) {
	switch (action.type) {
		case SEARCH_ADS: {
			console.log(action.payload.data);
			return [ action.payload.data];
			
		}
	}

	return state;
}