package com.example.mike.controller;


import com.example.mike.model.User;
import com.example.mike.service.IMPL.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class InitController {

    @Autowired
    UserServiceIMPL userService;


    @RequestMapping("/select")
    public String select(){
       User user =  userService.FindUser(1);
       System.out.println("id:"+user.getId());
       return "index";
    }
}
