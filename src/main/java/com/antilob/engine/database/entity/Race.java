package com.antilob.engine.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="course")
public class Race {

    @Id
    @org.springframework.data.annotation.Id
    private long id;

    @Column(name="course_challengeinterne")
    private String  internalChallenge;

    @Column(name="date")
    private Date racedate;

    @Column(name="lieu")
    private String  location;

    @Column(name="pays")
    private String  country;

    @Column(name="nom")
    private String  name;


    @Column(name="courseprincipaleid")
    private int mainRaceid;

    @ManyToOne(fetch = FetchType.EAGER)
    private Challenge challenge;

    private int km;

    @Column(name="metre")
    private int meter;

    @Column(name="nbreparticipants")
    private int nbrparticipants;

    @Column(name="nbreantilob")
    private int nbrclub;

    private int homepage;
    private String url;


    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Result>  resultList;

    public long getMemberCount() {
        Long count = resultList.stream()
                .filter(r -> r.getRace().getId() == this.id)
                .count();
        return count;
    }
    @Transient
    private int memberCount;

    @Transient
    private String distance;

    @Transient
    private String date;


    public void addResult(Result result){
        if (this.resultList == null){
            this.resultList = new ArrayList<>();
        }
        this.resultList.add(result);

    }

    public String getDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM");
        String dateStr =  formatter.format(racedate);
        return dateStr;
    }


    public String getDistance() {
        float distance = km+ (float)meter/1000;
        return String.valueOf(distance);
    }

    public Date getRacedate() {
        return racedate;
    }

    public void setRacedate(Date racedate) {
        this.racedate = racedate;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getInternalChallenge() {
        return internalChallenge;
    }

    public void setInternalChallenge(String internalChallenge) {
        this.internalChallenge = internalChallenge;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMainRaceId() {
        return mainRaceid;
    }

    public void setMainRaceId(int mainRaceId) {
        this.mainRaceid = mainRaceId;
    }

/*    public int getChallengeId() {
        return challengeid;
    }

    public void setChallengeId(int challengeId) {
        this.challengeid = challengeId;
    }*/

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public int getNbrparticipants() {
        return nbrparticipants;
    }

    public void setNbrparticipants(int nbrparticipants) {
        this.nbrparticipants = nbrparticipants;
    }

    public int getNbrclub() {
        return nbrclub;
    }

    public void setNbrclub(int nbrclub) {
        this.nbrclub = nbrclub;
    }

    public int getHomepage() {
        return homepage;
    }

    public void setHomepage(int homepage) {
        this.homepage = homepage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
