package com.macnss.repositories;

import com.macnss.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findConsultationById(int id);
}
