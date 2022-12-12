package com.macnss.service;

import com.macnss.model.Consultation;
import com.macnss.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConsultationService {
    ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> getAllConsultations(){
        return consultationRepository.findAll();
    }
    public Consultation getConsultationById(int id){
        return consultationRepository.findConsultationById(id);
    }
}
