package com.modulo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {


    @GetMapping({"/", "index"})
    public String home () {
        return "index";
    }

    @GetMapping("/destinos")
    public String destinos () {
        return "destinos";
    }

    @GetMapping("/promocoes")
    public String promocoes () {
        return "promocoes";
    }

    @GetMapping("/contato")
    public String contato () {
        return "contato";
    }
    
} 
