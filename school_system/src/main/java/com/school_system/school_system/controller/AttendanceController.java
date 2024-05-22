package com.school_system.school_system.controller;

import com.school_system.school_system.entities.Attendance;
import com.school_system.school_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        return new ResponseEntity<>(attendanceService.getAllAttendances(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(id);
        return attendance.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/mark")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        return new ResponseEntity<>(attendanceService.createAttendance(attendance), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}





