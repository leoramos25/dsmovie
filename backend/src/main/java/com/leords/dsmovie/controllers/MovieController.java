package com.leords.dsmovie.controllers;

import com.leords.dsmovie.dto.MovieDTO;
import com.leords.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    
    @GetMapping(value = "/{id}")
    public MovieDTO findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }
    
}
