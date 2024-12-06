package com.antilob.engine.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name="dernierresultat")
public class LastResult {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name="nomcourse")
    private String raceName;

    @Column(name="lieu")
    private String location;

    @Column(name="distance")
    private float distance;

    @Column(name="nbreparticipants")
    private int nbrParticipants;

    @Column(name="nomcoureur")
    private String runnerLastname;

    @Column(name="prenom")
    private String runnerFirstname;

    @Column(name="place")
    private int place;

    @Column(name="temps")
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    };


    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getNbrParticipants() {
        return nbrParticipants;
    }

    public void setNbrParticipants(int nbrParticipants) {
        this.nbrParticipants = nbrParticipants;
    }

    public String getRunnerLastname() {
        return runnerLastname;
    }

    public void setRunnerLastname(String runnerLastname) {
        this.runnerLastname = runnerLastname;
    }

    public String getRunnerFirstname() {
        return runnerFirstname;
    }

    public void setRunnerFirstname(String runnerFirstname) {
        this.runnerFirstname = runnerFirstname;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
