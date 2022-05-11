package com.leords.dsmovie.services;

import com.leords.dsmovie.dto.MovieDTO;
import com.leords.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository repository;
    
    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        var movies = repository.findAll(pageable);
        return movies.map(MovieDTO::new);
    }
    
    @Transactional(readOnly = true)
    public MovieDTO findOne(Long id) {
        var movie = repository.findById(id).get();
        return new MovieDTO(movie);
    }
    
}
