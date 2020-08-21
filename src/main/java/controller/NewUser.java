package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserServiceImpl;

@Controller
public class NewUser {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewUser(ModelMap model) {
        User newUser = new User();
        model.addAttribute("createNewUser", newUser);

        return "createUser";
    }


}
