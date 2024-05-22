package com.school_system.school_system.controller;

import com.school_system.school_system.entities.Query;
import com.school_system.school_system.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    private QueryService queryService;

    @PostMapping("/create-query")
    public ResponseEntity<Query> createQuery(@RequestBody Query query) {
        Query savedQuery = queryService.saveQuery(query);
        return new ResponseEntity<>(savedQuery, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Query>> getAllQueries() {
        List<Query> queries = queryService.getAllQueries();
        return new ResponseEntity<>(queries, HttpStatus.OK);
    }
}
