package com.macnss.service;

import com.macnss.model.Admin;
import com.macnss.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AdminService {

     AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    public void add(Admin admin){
        adminRepository.save(admin);
    }

    @Transactional
    public List<Admin> getAll(){
        return adminRepository.findAll();
    }

    @Transactional
    public Admin findByEmail(String email){
        return adminRepository.findByEmail(email);
    }

}
