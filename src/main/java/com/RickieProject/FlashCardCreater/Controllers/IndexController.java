package com.RickieProject.FlashCardCreater.Controllers;

import com.RickieProject.FlashCardCreater.Database.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping(value="/")
    public String indexMapping(){

        return "index";
    }


    //Test page
    @Secured(value={"USER"})
    @GetMapping(value="/AccessOnlyForUser")
    public String someMapping(){
        System.out.println("Success");
        return "AccessOnlyForUser";
    }


}
