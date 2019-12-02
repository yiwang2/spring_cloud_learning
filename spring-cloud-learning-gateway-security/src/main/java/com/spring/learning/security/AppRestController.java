package com.spring.learning.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AppRestController {
	@GetMapping("/demo")
	private String demo() {
		return "demo";
	}
}
