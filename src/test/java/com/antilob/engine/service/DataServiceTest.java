package com.antilob.engine.service;

import com.antilob.AppConfig;
import com.antilob.engine.database.entity.*;
import com.antilob.engine.database.repository.IRaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureDataJpa
@SpringBootTest
class DataServiceTest {


    @Autowired
    private DataService dataService;


    @Test
    void getRaceTest() {
        Long raceId = Long.valueOf(24020);
        Optional<Race> race = Optional.of(dataService.getRace(raceId));
        Assertions.assertTrue(race.isPresent());
    }


    @Test
    void getMemberList() {
        List<Member> members = dataService.getMemberList();
        Assertions.assertFalse(members.isEmpty());
        Assertions.assertTrue(members.size() > 0);
    }

    @Test
    void getEventList() {
        List<Event> events = dataService.getEventList();
        Assertions.assertFalse(events.isEmpty());
        Assertions.assertTrue(events.size() > 0);
    }

    @Test
    void getLastResultList() {
        List<LastResult> results = dataService.getLastResultList();
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() > 0);
    }

    @Test
    void getRaceList() {
        List<Race> races = dataService.getRaceList();
        Assertions.assertFalse(races.isEmpty());
        Assertions.assertTrue(races.size() > 0);

    }

    @Test
    void getChallengeList() {
        List<Challenge> challenges = dataService.getChallengeList();
        Assertions.assertFalse(challenges.isEmpty());
        Assertions.assertTrue(challenges.size() > 0);
    }

    @Test
    void getResultList() {
        List<Result> results = dataService.getResultList();
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() > 0);
    }

    @Test
    void getResultsOfRace() {
        int raceId = 24040;
        List<Result> results = dataService.getResultsOfRace(raceId);
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() > 0);

    }

    @Test
    void getResultsOfRaceAll() {
        int raceId = 24040;
        List<Result> results = dataService.getResultsOfRaceAll(raceId);
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertTrue(results.size() > 0);
    }

    @Test
    void getChallengeClubList() {
        List<ChallengeClub> challengeClub = dataService.getChallengeClubList();
        Assertions.assertFalse(challengeClub.isEmpty());
        Assertions.assertTrue(challengeClub.size() > 0);
    }


    @Test
    void getResultsOfMemberTest() {
        int memberId  = 9;
        List<Result> result = dataService.getResultsOfMember(memberId);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.size() == 23);
    }

    @Test
    void getMember() {
        Long memberId = Long.valueOf(9);
        Member member = dataService.getMember(memberId);
        Assertions.assertNotNull(member);
    }
}