package com.RickieProject.FlashCardCreater.Controllers;

import com.RickieProject.FlashCardCreater.Database.UserRepo;
import com.RickieProject.FlashCardCreater.Model.Role;
import com.RickieProject.FlashCardCreater.Model.User;
import com.RickieProject.FlashCardCreater.Service.CustomUserDetails;
import com.RickieProject.FlashCardCreater.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
import java.util.Set;

@Controller
public class DashBoard {

    @Autowired
    UserRepo repo;

    @Secured(value={"USER"})
    @GetMapping("/dashboard")
    public String dashBoard(ModelMap modelMap, @AuthenticationPrincipal CustomUserDetails userDetails){
        User user = userDetails.getUser();
        modelMap.put("user",user);
        return "dashBoard";
    }

    @GetMapping("/logout")
    public String logoutRedirect(){
        return "logoutNotify";
    }


}
