package com.example.cms.poc.strapi.web;

import com.example.cms.poc.strapi.domain.ClientGrant;
import com.example.cms.poc.strapi.domain.ClientToken;
import com.example.cms.poc.strapi.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenHolder {
    @Value("${strapi.api.username}")
    private String username;

    @Value("${strapi.api.password}")
    private String password;

    private final ContentRepository contentRepository;

    private ClientToken clientToken = null;

    public boolean isAuthenticated() {
        return clientToken != null;
    }

    public void authenticate() {
        clientToken = contentRepository.token(new ClientGrant(username, password));
    }

    public String getAccessToken() {
        return String.format("Bearer %s", clientToken.getAccessToken());
    }
}
