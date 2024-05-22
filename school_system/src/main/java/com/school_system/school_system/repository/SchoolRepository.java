package com.school_system.school_system.repository;

import com.school_system.school_system.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}