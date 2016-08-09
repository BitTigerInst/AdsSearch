export const SEARCH_ADS = "SEARCH_ADS";

export var searchAds = (searchText) => {
	return {
		type: SEARCH_ADS,
		payload: searchText
	};
};