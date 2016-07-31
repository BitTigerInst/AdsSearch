var $ = require('jquery');

export var startLogin = () => {
	return (dispatch, getState) => {

	};
};

export var setSearchText = (searchText) => {
	return {
		type: 'SET_SEARCH_TEXT',
		searchText: searchText
	};
};