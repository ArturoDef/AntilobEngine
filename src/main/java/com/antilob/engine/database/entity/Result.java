package com.antilob.engine.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Entity
@Table(name="resultats")
public class Result {

    @EmbeddedId
    private ResultMemberId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="courseid",insertable=false, updatable=false)
    @MapsId("raceId")
    private Race race;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="coureurid",insertable=false, updatable=false)
    @MapsId("memberId")
    private Member member;

    private int place;

    @Column(name="temps")
    private String time;

    @Transient
    private float points;


    public Result(Race race, Member member) {
        this.race = race;
        this.member = member;
        this.id= new ResultMemberId(race.getId(), member.getId());
    }

    public Result() {

    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    @Embeddable
    public static class ResultMemberId implements Serializable {

        private static final long serialVersionUID = 1L;

//        @Column(name="idcourse")
        private Long raceId;

//        @Column(name="idcoureur")
        private Long memberId;

        public ResultMemberId(){

        }

        public ResultMemberId(Long raceId, Long memberId) {
            this.raceId = raceId;
            this.memberId = memberId;
        }
    }

}
