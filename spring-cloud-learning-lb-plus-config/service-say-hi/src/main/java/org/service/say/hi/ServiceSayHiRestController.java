package org.service.say.hi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceSayHiRestController {

	@Value("${server.port}")
	String port;
	
	@Value("${default.name}")
	String defaultName;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name") String name) {
		
		if (name == null || name.trim().length()==0) {
			name = this.defaultName;
		}
		
		return "hi " + name + " ,i am from port:" + port;
	}
}
