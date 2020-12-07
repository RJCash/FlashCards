package com.RickieProject.FlashCardCreater.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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
