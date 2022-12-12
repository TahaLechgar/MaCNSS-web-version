package com.macnss.repositories;

import com.macnss.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelativeRepository extends JpaRepository<Relative, Long> {
    Relative findRelativeById(int id);
}
