package com.example.springboot.controller;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class TableController {

    private final UserService userService;

    @Autowired
    public TableController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String  listUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);

        return "users";
    }

    @RequestMapping(value = "createNew", method = RequestMethod.POST)
    public String createUser(Model model) {
        model.addAttribute("string", "Create");
        model.addAttribute("suffix", "new user");
        model.addAttribute("user", new User());
        return "create";
    }

    @RequestMapping(value = "create", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    public String addUserToBase(@RequestParam("name") String name, @RequestParam("password") String password) {
        userService.add(new User(convertToUTF8(name), password));
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam("update") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("string", "Update");
        model.addAttribute("suffix", "user");
        model.addAttribute("user", user);
        return "create";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {
        User user = userService.getById(Integer.parseInt(id));
        user.setName(convertToUTF8(name));
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
        public String deleteUser(@RequestParam("delete") String id) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/admin";
    }

    private String convertToUTF8(String name) {
        String utfName = null;
        try {
            utfName = new String(name.getBytes("ISO-8859-1"), Charset.forName("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return utfName;
    }
}
