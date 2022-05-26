package com.leords.dsmovie.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieRepositoryTest {
    
    @Autowired
    private MovieRepository repository;
    
    private Long existingId;
    private Long nonExistingId;
    
    @BeforeEach
    void setup() {
        existingId = 1L;
        nonExistingId = 0L;
    }
    
    @Test
    void findAllShouldReturnMovieList() {
       var movies = repository.findAll();
       
       assertFalse(movies.isEmpty());
    }
    
    @Test
    void findByIdShouldReturnMovieOptionalObjectWhenIdExist() {
        var movie = repository.findById(existingId);
        
        assertTrue(movie.isPresent());
        assertEquals(existingId, movie.get().getId());
    }
}