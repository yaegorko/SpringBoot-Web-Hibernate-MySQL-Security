package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Set;

@Controller
//@RequestMapping(value = "user")
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String youInformation(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByName(auth.getName());
        Set attachments = user.getRoles();
        model.addAttribute(user);
        model.addAttribute(attachments);
        return "user";
    }
}
