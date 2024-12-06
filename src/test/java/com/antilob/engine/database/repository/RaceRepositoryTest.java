package com.antilob.engine.database.repository;


import com.antilob.AppConfig;
import com.antilob.engine.database.entity.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureDataJpa
@SpringBootTest
public class RaceRepositoryTest {

    @Autowired
    private IRaceRepository raceRepository;

    @Test
    public void getRaceTest(){
        Long raceId = Long.valueOf(24020);
        System.out.println("Get race "+raceId);
        Optional<Race> race = raceRepository.findById(raceId);
        Assertions.assertTrue(race.isPresent());
    }


}
