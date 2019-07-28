/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Derslived
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
//    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping(value = "/about")
    @ResponseBody
    public String about() {
        return "<h1>About Us</h1>";
    }
    
    
    @GetMapping(value="/test")
    
    public void test(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        
        System.out.println(req.getLocalPort());
        resp.getWriter().println("<h1>hello text</h1>");
        
        
    }
    

}
