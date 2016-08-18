import { combineReducers } from 'redux';
import AdsReducer from './reducer_ads';
import SelectedAdReducer from './reducer_selected_ad'

const RootReducer = combineReducers({
	ads: AdsReducer,
	selectedAd: SelectedAdReducer
});

export default RootReducer;