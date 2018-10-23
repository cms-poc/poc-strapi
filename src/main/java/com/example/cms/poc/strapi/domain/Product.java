package com.example.cms.poc.strapi.domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Product {
    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private BigDecimal price;
}
