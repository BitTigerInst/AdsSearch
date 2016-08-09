import axios from 'axios';

export const SEARCH_ADS = 'SEARCH_ADS';

const BASE_URL = '/AdsSearch/';
const URL_SEARCH = 'search';

export var searchAds = (searchText) => {
	const url = `${BASE_URL}${URL_SEARCH}`;
	const params = {
		searchText: searchText
	};
	const request = axios.get(url, { params });
	
	return {
		type: SEARCH_ADS,
		payload: request
	};
};