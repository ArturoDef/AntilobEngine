package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Race;
import com.antilob.engine.database.entity.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ResultRepository{

    @PersistenceContext
    EntityManager entityManager;


    public Result save(Result result) {
         return new Result();
    }

    public void saveAll(List<Result> results) {

    }


    public List<Result> getResultsOfRace(Integer raceId){
        List<Result> results =  entityManager.createQuery("from Result where race.id = :raceId order by place", Result.class)
                .setParameter("raceId",raceId)
                .getResultList();
        return results;
    }

    @Transactional
    public List<Result> findAll(){
        return entityManager.createQuery("from Result", Result.class).getResultList();
    }

    @Transactional
    public List<Result> getResultsOfRaceAll(int raceId){
        Race race = entityManager.find(Race.class, raceId);
        int mainRaceId = race.getMainRaceId();
        String query = "from Result where race.id = :raceId"+
                                        " or (race.mainRaceid = :mainRaceId " +
                                               " and race.mainRaceid <>0)" +
                                        " or race.id = :mainRaceId" +
                                        " or race.mainRaceid = :raceId";

        List<Result> results =  entityManager.createQuery(query, Result.class)
                .setParameter("raceId",raceId)
                .setParameter("mainRaceId",mainRaceId)
                .getResultList();

        return results;
    }

    public List<Result> getResultsOfMember(Integer memberId){
/*        List<Result> results =  entityManager.createQuery(" select race,member, place, time,  "+
                                                            "(select sum(nbrClub) from race where race.id = id or id = race.mainRaceId).alias(sumpoints) " +
                                                            " from Result where member.id = :memberId order by id", Result.class)
                .setParameter("memberId",memberId)
                .getResultList();*/

/*        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Result> query = builder.createQuery(Result.class);
        Root<Result> root = query.from(Result.class);

        Subquery subquery = query.subquery(Result.class);*/

/*        String query = "from Result where " +
                "member.id = :memberId or "+
                " race.id in (select race.id  from Result where member.id = :memberId) or"+
                " race.id in (select race.mainRaceid  from Result where member.id = :memberId)";

                ;
        List<Result> results =  entityManager.createQuery(query, Result.class)
                .setParameter("memberId",memberId)
                .getResultList();
        System.out.println(" RESULT LIST \n");
        results.forEach(result->{

        });*/

        String query = "from Result where " +
                "member.id = :memberId  ";
        List<Result> results =  entityManager.createQuery(query, Result.class)
                .setParameter("memberId",memberId)
                .getResultList();
        return results;
    }
}
