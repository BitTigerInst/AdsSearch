import { combineReducers } from 'redux';
import AdsReducer from './reducer_ads';

const RootReducer = combineReducers({
	ads: AdsReducer
});

export default RootReducer;