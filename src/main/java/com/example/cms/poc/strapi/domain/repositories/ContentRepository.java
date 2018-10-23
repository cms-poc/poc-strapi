package com.example.cms.poc.strapi.domain.repositories;

import com.example.cms.poc.strapi.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@FeignClient("content")
public interface ContentRepository {
    @PostMapping("/auth/local")
    ClientToken token(@RequestBody ClientGrant clientGrant);

    default List<String> contentTypes() {
        List<String> schemas = new ArrayList<>();
        schemas.add("products");
        return schemas;
    }

    @GetMapping("/products")
    List<Product> products(@RequestHeader("Authorization") String bearerToken);

    @PostMapping("/products")
    void addProduct(@RequestBody Product itemData, @RequestHeader("Authorization") String bearerToken);
}
