package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Member;
import com.antilob.engine.database.entity.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRaceRepository extends CrudRepository<Race, Long>{
}
