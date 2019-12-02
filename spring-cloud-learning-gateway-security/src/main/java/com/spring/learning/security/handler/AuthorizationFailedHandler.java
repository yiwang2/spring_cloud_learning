package com.spring.learning.security.handler;

import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.spring.learning.security.response.MessageCode;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationFailedHandler extends HttpBasicServerAuthenticationEntryPoint{

	//private static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    //private static final String DEFAULT_REALM = "Realm";
    private static String WWW_AUTHENTICATE_FORMAT = "Basic realm=\"%s\"";
    private String headerValue = createHeaderValue("Realm");
    
    public AuthorizationFailedHandler () {
    	
    }
    
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
            response.getHeaders().set(HttpHeaders.AUTHORIZATION, this.headerValue);
            JsonObject result = new JsonObject();
            result.addProperty("status", MessageCode.COMMON_AUTHORIZED_FAILURE.getCode());
            result.addProperty("message", MessageCode.COMMON_AUTHORIZED_FAILURE.getMsg());
            byte[] dataBytes=result.toString().getBytes();
            DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
            return response.writeWith(Mono.just(bodyDataBuffer));
    }
    
    private static String createHeaderValue(String realm) {
        Assert.notNull(realm, "realm cannot be null");
        return String.format(WWW_AUTHENTICATE_FORMAT, new Object[]{realm});
    }
	
}
