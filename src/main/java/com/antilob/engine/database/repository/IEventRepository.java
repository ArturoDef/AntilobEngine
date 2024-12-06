package com.antilob.engine.database.repository;

import com.antilob.engine.database.entity.Event;
import org.springframework.data.repository.CrudRepository;


public interface IEventRepository extends CrudRepository<Event, Long>{

}
