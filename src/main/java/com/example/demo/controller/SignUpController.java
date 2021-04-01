package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private static final long CLIENT_ID = 7802850;
    private static final String REDIRECT_URI = "http://cccc.com:8080/pth/signup/vk";
    private static final String STATE = "auf";
    private static final int SCOPE = 273744030;

    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public String post(ModelMap modelMap, @Valid @ModelAttribute UserDto userDto) {
        signUpService.signUp(userDto);
        return "login";
    }

    @GetMapping
    public String index(
            @RequestParam(name = "with", required = false) String signUpWith,
                        HttpServletResponse httpServletResponse,
                        ModelMap map) {
        if (signUpWith == null) {
            map.put("userDto", new UserDto());
            return "signup";
        }

        String url = "https://oauth.vk.com/authorize?" +
                "client_id=" + CLIENT_ID +
                "&display=page" +
                "&redirect_uri=" + REDIRECT_URI +
                "&scope=" + SCOPE +
                "&response_type=code&v=5.130" +
                "&state=" + STATE;
        httpServletResponse.setHeader("Location", url);
        httpServletResponse.setStatus(302);
        return "redirect:" + url;
    }

}
