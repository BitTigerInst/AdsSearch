import React, { Component } from 'react';
import axios from 'axios';

export default class Login extends Component {
	constructor() {
		super();
		this.state = {
			username: '',
			password: ''
		};
	}

	login(e) {
		debugger
		e.preventDefault();
		var username = this.refs.username.value;
		var password = this.refs.username.value;

		var url = '/AdsSearch/login'
		var param = {
			username: username,
			password: password
		}

		axios.post(url, param).then((response) => {
			console.log(response);
		}).catch((error) => {
			console.log(error);
		});
	}

	render() {
		return (
			<div className="container-fluid">
				<div className="row">
					<div className="col-lg12 col-md-6 col-lg-4">
						<div className="callout callout-auth">
							<h3>Login</h3>
							<form role="form" onSubmit={(e) => this.login(e)}>
								<div className="form-group">
									<input type="text" ref="username" placeholder="username..."></input>
									<input type="password" ref="password" placeholder="password"></input>
									<input type="hidden" name="_csrf" value="d252d321-2673-497d-a793-7d6459ca1113" />
									<button type="submit" className="btn btn-primary">Login!</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		);
	}
}