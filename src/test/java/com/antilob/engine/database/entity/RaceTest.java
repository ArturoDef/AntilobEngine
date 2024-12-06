package com.antilob.engine.database.entity;

import com.antilob.AppConfig;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureDataJpa
@SpringBootTest
class RaceTest {

    private Race race = null;
    private Challenge challenge = null;
    @BeforeEach
    public void setUp() {
        challenge = Challenge.builder()
                .id(1)
                .shortname("newCh")
                .name("New Challenge")
                .build();

    race =  Race.builder()
                .id(123)
                .racedate(getDateTestValue("25-02-2024"))
                .name("TEST RACE")
                .internalChallenge("1")
                .location("LOCATION")
                .meter(500)
                .km(10)
                .url("http://testurl.com")
                .country("Belgique")
                .challenge(challenge)
                .homepage(0)
                .build();

    }

    @Test
    void getMemberCount() {
    }


    @Test
    void getDateTest() {
        String dateTest=race.getDate();
        assertNotNull(race);
        assertNotNull(dateTest);
        assertEquals("25/02", dateTest);
    }

    @Test
    void getDistanceTest() {
        String distanceTest=race.getDistance();
        assertNotNull(distanceTest);
        assertTrue(distanceTest.length()>0);
        Float distance=Float.parseFloat(distanceTest);
        assertTrue(distance>=0);
    }


    @Test
    void addResultAndCount(){
        Member member1 = Member.builder()
                .id(1001)
                .firstname("JEAN")
                .lastname("DUPOND")
                .build();
        Member member2 = Member.builder()
                .id(1002)
                .firstname("GERARD")
                .lastname("DURAND")
                .build();
        Member member3 = Member.builder()
                .id(1003)
                .firstname("GERARD")
                .lastname("DURAND")
                .build();
        Result result1 = Result.builder()
                        .member(member1)
                        .race(race)
                        .build();
        Result result2 = Result.builder()
                .member(member1)
                .race(race)
                .build();
        Result result3 = Result.builder()
                .member(member1)
                .race(race)
                .build();
        race.addResult(result1);
        race.addResult(result2);
        race.addResult(result3);
        assertEquals(3, race.getMemberCount());
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getInternalChallenge() {
        assertTrue(race.getInternalChallenge()!=null);
        assertTrue(race.getInternalChallenge().equals("1") || race.getInternalChallenge().equals("0"));
    }


    @Test
    void getLocation() {
        assertNotNull(race.getLocation());
    }

    @Test
    void getCountry() {
        assertNotNull(race.getCountry());
        assertEquals("Belgique", race.getCountry());
    }


    @Test
    void getMainRaceId() {
    }


    @Test
    void getKm() {
        assertTrue(race.getKm()>0);
    }


    @Test
    void getMeter() {
        assertTrue(race.getMeter()>0);
    }


    @Test
    void getNbrparticipants() {
    }


    @Test
    void getNbrclub() {
    }


    @Test
    void getHomepageTest() {
        assertNotNull(race.getHomepage());
    }


    @Test
    void getUrlTest() {
        assertNotNull(race.getUrl());
    }


    @Test
    void getNameTest() {
        assertNotNull(race.getName());
    }


    @Test
    void getChallengeTest() {
        assertNotNull(race.getChallenge());
    }

    @Test
    void setInternalChallenge() {
        String internalChallenge = "0";
        race.setInternalChallenge(internalChallenge);
        assertEquals(internalChallenge, race.getInternalChallenge());

    }
    @Test
    void setRacedate() {
        Date testDate = this.getDateTestValue("25-03-2024");
        race.setRacedate(testDate);
        assertEquals(testDate,race.getRacedate());
    }

/*    @Test
    void testSetId() {

    }*/

    @Test
    void setLocation() {
        String location = "NEWLOCATION";
        race.setLocation(location);
        assertEquals(location,race.getLocation());
    }

    @Test
    void setMainRaceId() {
        int mainRaceId = 24042;
        race.setMainRaceId(mainRaceId);
        assertEquals(mainRaceId,race.getMainRaceId());
    }

    @Test
    void setKm() {
        int km = 12;
        race.setKm(km);
        assertEquals(km,race.getKm());
    }

    @Test
    void setMeter() {
        int meter = 500;
        race.setMeter(meter);
        assertEquals(meter,race.getMeter());
    }

    @Test
    void setNbrparticipants() {
        int nbrParticipants = 100;
        race.setNbrparticipants(nbrParticipants);
        assertEquals(nbrParticipants,race.getNbrparticipants());
    }

    @Test
    void setNbrclub() {
        int nbrClub = 10;
        race.setNbrclub(nbrClub);
        assertEquals(nbrClub,race.getNbrclub());
    }

    @Test
    void setHomepage() {
        int testHomePage =0 ;
        race.setHomepage(testHomePage);
        assertEquals(testHomePage,race.getHomepage());
    }

    @Test
    void setUrl() {
        String testUrl="newUrl.com";
        race.setUrl(testUrl);
        assertEquals(testUrl,race.getUrl());
    }

    @Test
    void setName() {
        String testName = "newName";
        race.setName(testName);
        assertEquals(testName,race.getName());
    }

    @Test
    void setChallenge() {
        Challenge challenge = Challenge.builder()
                        .id(123)
                        .name("challengetest")
                        .shortname("CT")
                        .build();
        race.setChallenge(challenge);
        assertEquals(challenge,race.getChallenge());
    }

    @Test
    void setCountry(){
        String country = "France";
        race.setCountry(country);
        assertEquals(country,race.getCountry());
    }

    private Date getDateTestValue(String date_string){
        Date dateTest = null;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        try {
            dateTest = formatter.parse(date_string);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTest;
    }

}