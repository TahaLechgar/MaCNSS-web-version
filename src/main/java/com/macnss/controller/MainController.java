package com.macnss.controller;

import com.macnss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {
    AdminService adminService;

    @Autowired
    public MainController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session)
    {

        if(session.getAttribute("user") == null)
        {
            return "redirect:/login";
        }

//        Admin admin = new Admin();
//        admin.setEmail("admin@email.vv");
//        admin.setPassword("admin");
//        adminService.add(admin);
        model.addAttribute("admins", adminService.getAll());

        return "file";
    }

}
