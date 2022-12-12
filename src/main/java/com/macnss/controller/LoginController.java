package com.macnss.controller;

import com.macnss.model.Admin;
import com.macnss.model.superclasse.User;
import com.macnss.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@NoArgsConstructor
public class LoginController {

    AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("msg", "Invalid username or password");
            return "login";
        }

        Admin admin = adminService.findByEmail(user.getEmail());
        if (admin == null || !admin.getPassword().equals(user.getPassword())) {
            model.addAttribute("msg", "Invalid username or password");
            return "login";
        }

        session.setAttribute("user", admin);
        session.setAttribute("role", "agent");

        return "redirect:/file/add";
    }



}