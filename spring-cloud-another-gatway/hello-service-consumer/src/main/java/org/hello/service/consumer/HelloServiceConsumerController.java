package org.hello.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class HelloServiceConsumerController {

	private final String helloServiceUrl = "http://hello-service";
	private final WebClient.Builder webClientBuilder;
	private WebClient webClient;
	
	@Autowired
	public HelloServiceConsumerController (WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}
	
	@RequestMapping(method = RequestMethod.GET) //if we define a url here, we cannot be navigated from gateway
	public Mono<String> getHome() {
		String url = helloServiceUrl + "/hi/";
		return getWebClient().get().uri(url).retrieve().bodyToMono(String.class);
	}
	
    private WebClient getWebClient() {
        if (webClient == null) {
            webClient = webClientBuilder.build();
        }
        return webClient;
    }
}
