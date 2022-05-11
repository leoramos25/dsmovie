package com.leords.dsmovie.services;

import com.leords.dsmovie.dto.MovieDTO;
import com.leords.dsmovie.dto.ScoreDTO;
import com.leords.dsmovie.entities.Score;
import com.leords.dsmovie.entities.User;
import com.leords.dsmovie.repositories.MovieRepository;
import com.leords.dsmovie.repositories.ScoreRepository;
import com.leords.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        var user = userRepository.findByEmail(dto.getEmail());
        
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        
        var movie = movieRepository.findById(dto.getMovieId()).get();
        
        var score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        
        score = scoreRepository.saveAndFlush(score);
        
        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }
        
        var average = sum / movie.getScores().size();
        
        movie.setScore(average);
        movie.setCount(movie.getScores().size());
        
        movie = movieRepository.save(movie);
        
        return new MovieDTO(movie);
    }
    
}
