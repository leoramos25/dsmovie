package com.leords.dsmovie.controllers;

import com.leords.dsmovie.dto.MovieDTO;
import com.leords.dsmovie.dto.ScoreDTO;
import com.leords.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    
    @Autowired
    private ScoreService service;
    
    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        var movieDto = service.saveScore(dto);
        return movieDto;
    }
    
}
