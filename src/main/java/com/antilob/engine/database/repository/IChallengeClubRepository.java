package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.ChallengeClub;
import com.antilob.engine.database.entity.LastResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IChallengeClubRepository extends CrudRepository<ChallengeClub, String>{

}
