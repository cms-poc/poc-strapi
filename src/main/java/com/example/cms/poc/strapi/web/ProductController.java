package com.example.cms.poc.strapi.web;

import com.example.cms.poc.strapi.domain.Product;
import com.example.cms.poc.strapi.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final TokenHolder tokenHolder;

    private final ContentRepository contentRepository;

    @ModelAttribute("products")
    public List<Product> products() {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        return contentRepository.products(tokenHolder.getAccessToken());
    }

    @GetMapping("/products")
    public String view() {
        return "products";
    }

    @PostMapping("/products")
    public String createItem(@ModelAttribute Product product) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        contentRepository.addProduct(product, tokenHolder.getAccessToken());
        return "redirect:/products";
    }
}
