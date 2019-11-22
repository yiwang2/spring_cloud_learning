package org.service.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiFallbackByHystric implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {
		return "Sorry "+ name;
	}

}
