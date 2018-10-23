package com.example.cms.poc.strapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public final class ClientGrant {
    @NonNull
    @JsonProperty("identifier")
    private final String identifier;

    @NonNull
    @JsonProperty("password")
    private final String password;
}
