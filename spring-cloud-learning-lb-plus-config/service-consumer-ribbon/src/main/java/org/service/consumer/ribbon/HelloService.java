package org.service.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${remote.service}")
	String serviceName;

	@HystrixCommand(fallbackMethod="hiError")
	public String hiService(String name) {
		return this.restTemplate.getForObject("http://"+serviceName+"/hi?name="+name, String.class);
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
