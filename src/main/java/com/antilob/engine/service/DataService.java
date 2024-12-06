package com.antilob.engine.service;

import com.antilob.engine.database.entity.*;
import com.antilob.engine.database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;



@Service
public class DataService implements IDataService {

    @Autowired
    private IMemberRepository memberRepository;
    @Autowired
    private IEventRepository eventRepository;
    @Autowired
    private ILastresultRepository lastResultRepository;
    @Autowired
    private IRaceRepository raceRepository;
    @Autowired
    private IChallengeRepository challengeRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private IChallengeClubRepository challengeClubRepository;
/*    @Autowired
    private HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration stringHttpMessageConverterConfiguration;*/

/*    public DataService(IMemberRepository memberRepository,
                       IEventRepository eventRepository,
                       ILastresultRepository lastResultRepository,
                       IRaceRepository raceRepository) {

        this.memberRepository = memberRepository;
        this.eventRepository = eventRepository;
        this.lastResultRepository = lastResultRepository;
        this.raceRepository = raceRepository;
    }*/

    public List<Member> getMemberList(){
        List memberList = new ArrayList();

        Iterable<Member> memberIterable = memberRepository.findAll();
        memberIterable.forEach(memberList::add);
        return  memberList;

    }

    public List<Event> getEventList(){
        List eventList = new ArrayList();

        Iterable<Event> eventIterable = eventRepository.findAll();
        eventIterable.forEach(eventList::add);
        return  eventList;
    }

    public List<LastResult> getLastResultList(){
        List resultList = new ArrayList();

        Iterable<LastResult> resultIterable = lastResultRepository.findAll();
        resultIterable.forEach(resultList::add);
        resultList.sort(new ResultListComparator());
//        Collections.sort(resultList,new ResultListComparator());
        return  resultList;
    }


    class ResultListComparator implements Comparator<LastResult> {
        @Override
        public int compare(LastResult o1, LastResult o2) {

            String valueo1= o1.getId().split("_")[0]+"_"+padString(String.valueOf(o1.getPlace()));
            String valueo2 = o2.getId().split("_")[0]+"_"+padString(String.valueOf(o2.getPlace()));
            return valueo1.compareTo(valueo2);
        }
    }
    private String padString(String s){
        String padded = "0000".substring(s.length()) + s;
        return padded;
    }

    public List<Race> getRaceList(){
        System.out.println("Get Race list");
        List raceList = new ArrayList();
        Iterable<Race> eventIterable = raceRepository.findAll();
        eventIterable.forEach(raceList::add);
        return  raceList;
    }
    public List<Challenge> getChallengeList(){
        System.out.println("Get Challenge list");
        List challengeList = new ArrayList();
        Iterable<Challenge> eventIterable = challengeRepository.findAll();
        eventIterable.forEach(challengeList::add);
        return  challengeList;
    }

    public List<Result> getResultList(){
        System.out.println("Get Result list");
        List resultList = new ArrayList();
        Iterable<Result> eventIterable = resultRepository.findAll();
        eventIterable.forEach(resultList::add);
        return  resultList;

    }

    public List<Result> getResultsOfRace(int raceId){
        System.out.println("Get Result list");
        List resultList = new ArrayList();
        Iterable<Result> eventIterable = resultRepository.getResultsOfRace(raceId);
        eventIterable.forEach(resultList::add);
        return  resultList;
    }

    public Race getRace(Long raceId){
        System.out.println("Get race "+raceId);
        Optional<Race> race = raceRepository.findById(raceId);
        return  race.get();

    }

    public List<Result> getResultsOfRaceAll(int raceId){
        System.out.println("Get Result list");
        List resultList = new ArrayList();
        Iterable<Result> eventIterable = resultRepository.getResultsOfRaceAll(raceId);
        eventIterable.forEach(resultList::add);
        return  resultList;
    }

    public List<ChallengeClub> getChallengeClubList(){
        List challengeClubList = new ArrayList();

        Iterable<ChallengeClub> challengeClubIterable = challengeClubRepository.findAll();
        challengeClubIterable.forEach(challengeClubList::add);
        return  challengeClubList;
    }

    public List<Result> getResultsOfMember(int memberId){
/*        System.out.println("Get Result list of member :" + memberId );
        List<Result> resultList = new ArrayList();
        Iterable<Result> eventIterable = resultRepository.getResultsOfMember(memberId);
        eventIterable.forEach(resultList::add);
        List<Result> resultsOfMember = resultList.stream()
                .filter(r -> r.getMember().getId() == memberId).collect(Collectors.toList());
        resultsOfMember.forEach(subResult ->{
            int nbClub  = resultList.stream()
                    .filter(r -> ((r.getRace().getId() == subResult.getRace().getId()) ||  (r.getRace().getMainRaceId() == subResult.getRace().getId()))).collect(Collectors.toList()).size();
            float numberParticpants =
        });*/

        List<Race> raceList = getRaceList();
        List<Result> resultList = new ArrayList();
        Iterable<Result> eventIterable = resultRepository.getResultsOfMember(memberId);
        eventIterable.forEach(resultList::add);
        resultList.forEach(subResult ->{
            Long raceId = subResult.getRace().getId();
            int mainRaceId = subResult.getRace().getMainRaceId();
            List<Race> subRaceList = raceList.stream()
                    .filter(r -> ((r.getId() == raceId) ||  (r.getMainRaceId() == raceId  || r.getId() == mainRaceId ))).collect(Collectors.toList()  );

            int nbClub = subRaceList.stream().mapToInt(r->r.getNbrclub()).sum();
            float nbParticipants = subResult.getRace().getNbrparticipants();
            float distance = Float.parseFloat( subResult.getRace().getDistance() );
            subResult.setPoints((float) ((  (nbClub*nbParticipants)/subResult.getPlace())*distance*0.001)) ;
        });
        return  resultList;
    }

    public Member getMember(Long memberId){
        Optional<Member> member = memberRepository.findById(memberId);
        return  member.get();
    }

/*    private float calculatePoints(List<Result> resultList ){
        float totalPoints = 0;
        resultList.forEach(result -> {
            Race race = result.getRace();
            List

        });
        return totalPoints;

    }*/


}
