package com.school_system.school_system.repository;

import com.school_system.school_system.entities.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}