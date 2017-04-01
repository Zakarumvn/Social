package com.social.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Katarzyna on 2017-02-26.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }


}
