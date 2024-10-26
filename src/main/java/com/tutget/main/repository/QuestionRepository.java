package com.tutget.main.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.tutget.main.model.Question;

public interface QuestionRepository extends ListCrudRepository<Question, String> {
    
}
