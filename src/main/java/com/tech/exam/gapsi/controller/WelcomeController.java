/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.exam.gapsi.controller;

import com.tech.exam.gaspi.vo.WelcomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WelcomeController {
    
    @Autowired 
    Environment env;
    
    @GetMapping("/welcome/{candidate}")
    public WelcomeMessage getWelcomeMessage(@PathVariable String candidate){
        return new WelcomeMessage(candidate, 
                env.getProperty("info.app.version") + " - " + env.getProperty("build.version"));
    }
    
    
}
