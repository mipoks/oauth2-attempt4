package com.example.demo.controller;

import com.example.demo.model.Page;
import com.example.demo.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    PageRepository pageRepository;

    @GetMapping(value = "/post/{post-id}")
    public String getUser(@PathVariable("post-id") Long pageId, ModelMap map) {
        Optional<Page> optionalPage = pageRepository.findById(pageId);
        if (optionalPage.isPresent())
            map.put("page", optionalPage.get());
        return "page";
    }
}
