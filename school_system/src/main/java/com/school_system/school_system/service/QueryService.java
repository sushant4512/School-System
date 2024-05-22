package com.school_system.school_system.service;

import com.school_system.school_system.entities.Query;
import com.school_system.school_system.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {
    @Autowired
    private QueryRepository queryRepository;

    public Query saveQuery(Query query) {
        return queryRepository.save(query);
    }

    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }
}