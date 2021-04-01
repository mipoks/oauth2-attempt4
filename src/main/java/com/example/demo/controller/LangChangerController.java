package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LangChangerController {

    @Autowired
    private LocaleResolver localeResolver;

    @RequestMapping("/change")
    public String change(@RequestParam String locale, HttpServletRequest request, HttpServletResponse response){
        String[] localeData = locale.split("_");
        localeResolver.setLocale(request, response, new Locale(localeData[0], localeData[1]));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("NC#index").build();
    }
}
