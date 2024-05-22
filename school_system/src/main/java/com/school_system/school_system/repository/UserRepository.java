package com.school_system.school_system.repository;
import com.school_system.school_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findByEmail(String email);
}