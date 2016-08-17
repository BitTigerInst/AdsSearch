export default function(state = null, action) {
	switch(action.type) {
		case 'AD_SELECTED':
			return action.payload;
	}

	return state;
}