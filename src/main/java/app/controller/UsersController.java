package app.controller;

import app.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @GetMapping("/user/new")
    public String getNewUserForm(Model model){
        model.addAttribute("user", new UserModel());
        return "user/new";
    }

    @PostMapping("/user/new")
    public String postCreateUser(@ModelAttribute UserModel user){
        System.out.println(user.tableParams());
        user.save("users", user.tableParams());
        return "user/show";
    }


}
