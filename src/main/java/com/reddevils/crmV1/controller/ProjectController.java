/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.controller;

import com.reddevils.crmV1.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Derslived
 */
@Controller

@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @GetMapping

    public String index(Model model) throws Exception {

        model.addAttribute("projectList", projectRepo.findAll());

        return "admin/projects/index";

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String detail(@PathVariable("id") int id) {

        int data = id * 5;
        return "data is" + data;

    }

}
