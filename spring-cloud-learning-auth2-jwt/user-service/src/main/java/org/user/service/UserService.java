package org.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.user.service.client.AuthServiceClient;
import org.user.service.dao.UserDao;
import org.user.service.dto.UserLoginDTO;
import org.user.service.entity.*;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	AuthServiceClient authServiceClient;
	
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	

	public User create(String username, String password) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(encoder.encode(password));

		User u = userDao.save(user);
		return u;
	}

	public UserLoginDTO login(String username, String password) throws Exception {
		User user = userDao.findByUsername(username);
		if (null == user) {
			throw new Exception("error username");
		}
		if (!encoder.matches(password, user.getPassword())) {
			throw new Exception("error password");
		}
		
		//uaa-service:123456

		JWT jwt = authServiceClient.getToken("Basic "+"dWFhLXNlcnZpY2U6MTIzNDU2", "password", username, password);
		if (null == jwt) {
			throw new Exception("error internal");
		}

		UserLoginDTO userLoginDTO = new UserLoginDTO();
		userLoginDTO.setJwt(jwt);
		userLoginDTO.setUser(user);

		return userLoginDTO;
	}
}
