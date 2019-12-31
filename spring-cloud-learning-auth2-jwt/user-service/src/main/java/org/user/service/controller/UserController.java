package org.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.user.service.UserService;
import org.user.service.dto.UserLoginDTO;
import org.user.service.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		return userService.create(username, password);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserLoginDTO login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		return userService.login(username, password);
	}
}
