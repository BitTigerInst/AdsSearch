import React, { Component } from 'react';
import ReactMixin from 'react-mixin';

export default class Login extends Component {
	constructor() {
		super();
		this.state = {
			username: '',
			password: ''
		};
	}

	login(e) {
		e.preventDefault();

		Auth.login(this.state.username, this.state.password)
			.catch((err) => {
				console.log('Error logging in', err);
			});
	}

	render() {
		return (
			<div>
				<h1 className="page-title">Todo App</h1>
				<div className="row">
					<div className="col-xs-10 col-md-6 col-lg-4">
						<div className="callout callout-auth">
							<h3>Login</h3>
							<form role="form">
								<div className="form-group">
									<input type="text" valueLink={this.linkState('username')} placeholder="username..."></input>
									<input type="password" valueLink={this.linkState('password')} placeholder="password"></input>
								</div>
							</form>
							<button type="submit" className="button" onClick={this.login.bind(this)}>Login!</button>
						</div>
					</div>
				</div>
			</div>
		);
	}
}