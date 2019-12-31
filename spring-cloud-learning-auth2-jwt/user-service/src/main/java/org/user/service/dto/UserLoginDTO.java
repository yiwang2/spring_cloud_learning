package org.user.service.dto;

import org.user.service.entity.JWT;
import org.user.service.entity.User;

public class UserLoginDTO {

	private JWT jwt;
	private User user;

	public JWT getJwt() {
		return jwt;
	}

	public void setJwt(JWT jwt) {
		this.jwt = jwt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
