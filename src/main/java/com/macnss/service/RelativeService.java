package com.macnss.service;

import com.macnss.model.Relative;
import com.macnss.repositories.RelativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RelativeService {
    RelativeRepository relativeRepository;

    @Autowired
    public RelativeService(RelativeRepository relativeRepository) {
        this.relativeRepository = relativeRepository;
    }

    public Relative getRelativeById(int id){
        return relativeRepository.findRelativeById(id);
    }

    public List<Relative> getAllRelatives() {
        return relativeRepository.findAll();
    }
}
