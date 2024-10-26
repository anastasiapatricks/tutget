package com.tutget.main.controller;

import com.tutget.main.model.Answer;
import com.tutget.main.model.Question;
import com.tutget.main.model.QuestionWithAnswers;
import com.tutget.main.service.QnaService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/qna")
public class QnaController {
    
    @Autowired
    private QnaService qnaService;

    @RequestMapping("/getQuestions")
    public List<Question> getQuestions() {
        return qnaService.getAllQuestions();
    }

    @RequestMapping("/getQuestion/{id}")
    public QuestionWithAnswers getQuestionWithAnswers(@PathVariable String id) {
        Optional<QuestionWithAnswers> o = qnaService.getQuestionWithAnswersById(id);
        if (o.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return o.get();
    }

    @RequestMapping("/getAnswers/{id}")
    public List<Answer> getAnswersByQuestionId(@PathVariable String id) {
        return qnaService.getAnswersByQuestionId(id);
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question){
        return qnaService.addQuestion(question);
    }

    @PostMapping("/addAnswer")
    public String addQuestion(@RequestBody Answer answer){
        return qnaService.addAnswer(answer);
    }
}
