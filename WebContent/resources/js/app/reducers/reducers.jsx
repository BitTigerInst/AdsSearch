import { combineReducers } from 'redux';
import SearchTextReducer from './reducer-search-text.jsx';

const RootReducer = combineReducers({
	searchText: SearchTextReducer
});

export default RootReducer;