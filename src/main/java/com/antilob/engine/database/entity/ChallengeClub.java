package com.antilob.engine.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="challengeclub")
public class ChallengeClub {

    @Id
    @org.springframework.data.annotation.Id
    private long id;

    @Column(name="prenom")
    private String firstname;

    @Column(name="nom")
    private String lastname;

    @Column(name="nbcourses")
    private int nbRace;

    private float sumpoints;

    private float distance;

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getNbRace() {
        return nbRace;
    }

    public float getSumpoints() {
        return sumpoints;
    }

    public float getDistance() {
        return distance;
    }
}