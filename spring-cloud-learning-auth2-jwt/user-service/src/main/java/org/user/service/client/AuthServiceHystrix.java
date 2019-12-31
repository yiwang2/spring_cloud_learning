package org.user.service.client;

import org.springframework.stereotype.Component;
import org.user.service.entity.JWT;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
