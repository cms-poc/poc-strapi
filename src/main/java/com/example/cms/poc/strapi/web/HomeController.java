package com.example.cms.poc.strapi.web;

import com.example.cms.poc.strapi.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ContentRepository contentRepository;

    @ModelAttribute("contentTypes")
    public List<String> contentTypes() {
        return contentRepository.contentTypes();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
