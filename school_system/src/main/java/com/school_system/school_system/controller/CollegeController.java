package com.school_system.school_system.controller;
import com.school_system.school_system.entities.College;
import com.school_system.school_system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }
}