package com.school_system.school_system.controller;

import com.school_system.school_system.entities.School;
import com.school_system.school_system.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/schools")
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }
}