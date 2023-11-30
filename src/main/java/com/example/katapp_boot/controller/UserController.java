package com.example.katapp_boot.controller;

import com.example.katapp_boot.entity.User;
import com.example.katapp_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("listUsers", userService.getListUsers());
        return "users";
    }

    @GetMapping("/user")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PutMapping("/user")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
