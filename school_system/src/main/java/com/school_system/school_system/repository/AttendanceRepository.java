
package com.school_system.school_system.repository;

import com.school_system.school_system.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
   // List<Attendance> findByStudentId(Long studentId);
}

