package org.hello.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {

	@RequestMapping("/hi")
	public String home() {
		return "Say hi to Hello Service";
	}
}
