package com.RickieProject.FlashCardCreater.Controllers;

import com.RickieProject.FlashCardCreater.Database.UserRepo;
import com.RickieProject.FlashCardCreater.Database.UserService;
import com.RickieProject.FlashCardCreater.Model.User;
import com.RickieProject.FlashCardCreater.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Registration {

    @Autowired
    UserRepo repo;

    @Autowired
    UserService service;

    @GetMapping(value="/registration")
    public String showPage(ModelMap mm){
        mm.put("user",new User());
        System.out.println(mm.getAttribute("user"));
        return "registration";
    }

    @PostMapping(value="/registration")
    public String register(@ModelAttribute("user") User user){
        System.out.println(user.toString());
        System.out.println("Retrieved user: Success");
        service.save(user,repo);
        System.out.println("Saved user: Success");
        return "redirect:/login";
    }
}
