package com.example.demo.controller;

import com.example.demo.dto.PageDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/create")
public class CreateController {

  @Autowired
  PageService pageService;

  @Autowired
  private UserRepository userRepo;

  @PostMapping
  public String createPost(HttpServletRequest response, ModelMap map, @Valid @ModelAttribute("pageDto") PageDto pageDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      map.put("pageDto", pageDto);
      map.put("owners", userRepo.findAll());
      return "create";
    }
    Long pageId = pageService.addPage(pageDto);
    return "redirect:post/" + pageId;
  }


  @GetMapping
  public String index(ModelMap map){
    map.put("pageDto", new PageDto());
    map.put("owners", userRepo.findAll());
    return "create";
  }

}
