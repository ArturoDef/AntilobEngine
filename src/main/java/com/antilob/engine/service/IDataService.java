package com.antilob.engine.service;

import java.util.List;

import com.antilob.engine.database.entity.*;

public interface IDataService {
    List<Member> getMemberList();
    List<Event> getEventList();
    List<LastResult> getLastResultList();
    List<Race> getRaceList();
    List<Challenge> getChallengeList();
    List<Result> getResultList();
    List<Result> getResultsOfRace(int raceId);
    Race getRace(Long raceId);
    List<Result> getResultsOfRaceAll(int raceId);
    List<ChallengeClub> getChallengeClubList();
     List<Result> getResultsOfMember(int memberId);
    Member getMember(Long memberId);
}
