package com.example.demo.controller;

import com.example.demo.model.Page;
import com.example.demo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewsController {

    private static int NUM_POST_IN_PAGE = 5;
    @Autowired
    PageService pageService;

    @RequestMapping({"/news", "/"})
    public String index(ModelMap map,
                        @RequestParam(name = "page", required = false) Integer page){
        if (page == null || page < 0)
            page = 0;
        List<Page> temp = pageService.getPages(NUM_POST_IN_PAGE, page);
        System.out.println(temp);
        map.put("pages", temp);
        map.put("pageNext", page + 1);
        map.put("pagePrev", page - 1);
        return "index";
    }

}
