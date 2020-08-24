package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class Homepage {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping()
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hi mate!");
        messages.add("Choose what you want to do");
        model.addAttribute("messages", messages);

        List<User> users = userServiceImpl.findAll();
        model.addAttribute("newUsers", users);
        return "index";
    }

}
