/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.controller;

import com.reddevils.crmV1.entity.UserLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Derslived
 */

@Controller
@RequestMapping(value="/userlog")
public class UserLogController {
    
    @GetMapping
    @ResponseBody
    public UserLog index(@ModelAttribute("UserLog") UserLog log){
        
        return log;
    }
    
    
}
