package com.tutget.main.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.tutget.main.model.Answer;

public interface AnswerRepository extends ListCrudRepository<Answer, String> {
    
}
