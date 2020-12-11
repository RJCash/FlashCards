package com.RickieProject.FlashCardCreater.Controllers;

import com.RickieProject.FlashCardCreater.Database.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    UserRepo repo;

    @GetMapping(value="/")
    public String indexMapping(){

        return "index";
    }

    //Test page
    @GetMapping(value="/AccessOnlyForUser")
    public String someMapping(){
        return "AccessOnlyForUser";
    }


}
