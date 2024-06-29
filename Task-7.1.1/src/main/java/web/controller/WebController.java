package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

@Controller
public class WebController {
    private final UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUser(ModelMap model) {
        return "createUser";
    }

    @GetMapping(value="/updateUser")
    public String updateUser() {
        return "updateUser";
    }

    @GetMapping(value = "/removeUser")
    public String removeUser() {
        return "removeUser";
    }
}
