package com.macnss.repositories;

import com.macnss.model.PatientFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientFileRepository extends JpaRepository<PatientFile, Long> {

}
