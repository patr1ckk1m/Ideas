package com.patrick.belt1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrick.belt1.models.Idea;


@Repository
public interface IdeaRepo extends CrudRepository<Idea, Long>{

}
