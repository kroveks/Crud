package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImpl;

@Controller

public class EditUser {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/edit")
    public String editUserForm(ModelMap model, @RequestParam long id) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        userServiceImpl.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("jesus") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("allah") User user) {
        userServiceImpl.update(user);
        return "redirect:/";
    }



}
