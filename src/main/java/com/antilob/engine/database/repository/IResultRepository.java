package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Race;
import com.antilob.engine.database.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IResultRepository extends CrudRepository<Result, Long>{
}
