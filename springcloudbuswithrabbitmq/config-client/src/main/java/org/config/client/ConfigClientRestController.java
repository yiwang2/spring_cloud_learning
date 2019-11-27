package org.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientRestController {

	@Value("${hello}")
	String hello;

	@RequestMapping(value = "/hi")
	public String hi(){
		return hello;
	}
}
