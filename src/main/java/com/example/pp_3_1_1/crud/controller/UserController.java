package com.example.pp_3_1_1.crud.controller;

import com.example.pp_3_1_1.crud.model.User;
import com.example.pp_3_1_1.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
@Validated
public class UserController {

    private final IUserService usServ;
    private final String firstPage = "redirect:/";

    @Autowired
    public UserController(IUserService usServ) {this.usServ = usServ;}

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", usServ.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "new";
        usServ.createUser(user);
        return firstPage;
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usServ.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "edit";
        usServ.update(id, user);
        return firstPage;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usServ.delete(id);
        return firstPage;
    }
}
