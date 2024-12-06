package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Event;
import com.antilob.engine.database.entity.LastResult;
import org.springframework.data.repository.CrudRepository;


public interface ILastresultRepository extends CrudRepository<LastResult, String>{

}
