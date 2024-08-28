package com.hellmanstudios.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @RequestMapping("*")
    @ResponseBody
    public String notFound() {
        return "Page not found. Try /hello with your name and age as parameters!";
    }


    @RequestMapping("/hello")
    public String hello(@RequestParam(name="name", defaultValue = "unknown") String name, @RequestParam(name="age", defaultValue = "0") String ageString, Model model) {
        model.addAttribute("name", name);
        int age = Integer.parseInt(ageString);
        model.addAttribute("age", age);
        return "index";
    }

}
