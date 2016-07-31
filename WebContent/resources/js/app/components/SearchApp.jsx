import React, { Component } from 'react';
import { createStore, applyMiddleware} from 'redux';
import AdsSearch from '../containers/AdsSearch';
import RootReducer from '../reducers/reducers.jsx';
import {connect} from 'react-redux';

const createStoreWithMiddleware = applyMiddleware()(createStore);

export class SearchApp extends Component {
  	render() {
	    return (
	      <Provider store={createStoreWithMiddleware(RootReducer)}>
      		 <AdsSearch />
	      </Provider>
	    );
  	}
}
