package com.learning.spring.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;


public class AddRequestHeaderGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory{

	public GatewayFilter apply(NameValueConfig config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest().mutate()
					.header(config.getName(), config.getValue())
					.build();

			return chain.filter(exchange.mutate().request(request).build());
		};
	}

}
