package org.service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceHiController {

	@Autowired
	private SchedualServiceHi serviceHi;
	
	@GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return serviceHi.sayHiFromClientOne( name );
    }
}
