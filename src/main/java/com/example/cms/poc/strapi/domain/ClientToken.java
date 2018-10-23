package com.example.cms.poc.strapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ClientToken {
    @NonNull
    @JsonProperty("jwt")
    private String accessToken;
}
