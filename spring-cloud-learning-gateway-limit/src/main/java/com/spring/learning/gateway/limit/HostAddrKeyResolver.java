package com.spring.learning.gateway.limit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class HostAddrKeyResolver implements KeyResolver{

	public Mono<String> resolve(ServerWebExchange exchange) {
		return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}

}
