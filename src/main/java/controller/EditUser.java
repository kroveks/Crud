package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserServiceImpl;

@Controller
public class EditUser {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("updateUser") User user) {
        userServiceImpl.update(user);
        return "edit";
    }



}
