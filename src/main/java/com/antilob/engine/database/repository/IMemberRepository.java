package com.antilob.engine.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.antilob.engine.database.entity.Member;


public interface IMemberRepository extends JpaRepository<Member, Long>{
}
