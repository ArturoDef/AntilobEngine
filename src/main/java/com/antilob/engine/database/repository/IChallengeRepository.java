package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Challenge;
import com.antilob.engine.database.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IChallengeRepository extends JpaRepository<Challenge, Long>{
}
