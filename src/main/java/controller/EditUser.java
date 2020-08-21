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

//    @GetMapping("/edit")
//    public String editUserForm(ModelMap model, @RequestParam long id) {
//        model.addAttribute("editUser", userServiceImpl.findById(id));
//        return "edit";
//    }
//
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam long id) {
//        userServiceImpl.deleteById(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveUser(@ModelAttribute("saveUser") User user) {
//        userServiceImpl.save(user);
//        return "redirect:/";
//    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("updateUser") User user) {
        userServiceImpl.update(user);
        return "edit";
    }



}