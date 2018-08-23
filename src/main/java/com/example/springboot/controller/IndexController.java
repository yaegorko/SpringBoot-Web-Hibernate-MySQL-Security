package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("loginUserService")
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toTable() {
        return "redirect:/login" ;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginPage() {
        return "login";
    }
}

