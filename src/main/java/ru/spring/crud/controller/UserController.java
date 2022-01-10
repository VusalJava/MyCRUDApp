package ru.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.crud.model.User;
import ru.spring.crud.service.UserService;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String printUsers(Model model){
        model.addAttribute("_users",userService.readAllUsers());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("_user",userService.getUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("_user")User user){
        return "users/new";
    }

    @Transactional
    @PostMapping()
    public String createUser(@ModelAttribute("_user") User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id,Model model){
        model.addAttribute("_user",userService.getUserById(id));
        return "users/edit";
    }

    @Transactional
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("_user") User user,@PathVariable("id") Long id){
        userService.update(id,user);
        return "redirect:/users";
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("_user") User user,@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }




}
