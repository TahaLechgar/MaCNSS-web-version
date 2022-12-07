package com.macnss.controller;

import com.macnss.model.Admin;
import com.macnss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
    AdminService adminService;

    @Autowired
    public MainController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/main")
    public String main(Model model)
    {

        Admin admin = new Admin();
        admin.setEmail("admin@email.vv");
        admin.setPassword("admin");
        adminService.add(admin);
        model.addAttribute("admins", adminService.getAll());

        return "welcome";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
