package com.abasjr.abasweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @RequestMapping()
    public String index(){
        return "hello";
    }

    @RequestMapping("hello_name")
    public String hello2(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_name";
    }

}