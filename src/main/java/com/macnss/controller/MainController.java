package com.macnss.controller;

import com.macnss.model.Admin;
import com.macnss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    AdminService adminService;

    @Autowired
    public MainController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/main")
    @ResponseBody
    public String main()
    {

        Admin admin = new Admin();
        admin.setEmail("admin@email.vv");
        admin.setPassword("admin");
        adminService.add(admin);

        return "Hehe Boy";
    }
}
