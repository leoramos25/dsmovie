package com.leords.dsmovie.repositories;

import com.leords.dsmovie.entities.Score;
import com.leords.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
