package com.tutget.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutget.main.model.Answer;
import com.tutget.main.model.Question;
import com.tutget.main.model.QuestionWithAnswers;
import com.tutget.main.repository.AnswerRepository;
import com.tutget.main.repository.QuestionRepository;

@Service
public class QnaService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Answer> getAnswersByQuestionId(String id) {
        Optional<Question> o = questionRepository.findById(id);
        if (!o.isPresent()) {
            return null;
        }
        Question q = o.get();
        return answerRepository.findAllById(q.getAnswers());
    }

    public Optional<Question> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    public Optional<QuestionWithAnswers> getQuestionWithAnswersById(String id) {
        Optional<Question> o = questionRepository.findById(id);
        if (!o.isPresent()) {
            return Optional.empty();
        }

        Question q = o.get();
        List<Answer> answers = answerRepository.findAllById(q.getAnswers());

        QuestionWithAnswers qa = new QuestionWithAnswers();
        qa.setQuestion(o.get());
        qa.setAnswers(answers);

        return Optional.of(qa);
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return question.getId();
    }

    public String addAnswer(Answer answer) {
        answerRepository.save(answer);

        Question question = questionRepository.findById(answer.getQuestionId()).get();
        question.addAnswer(answer.getId());
        questionRepository.save(question);

        return answer.getId();
    }

    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }

    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    public void deleteAnswer(String id) {
        Answer answer = answerRepository.findById(id).get();
        Question question = questionRepository.findById(answer.getQuestionId()).get();
        question.removeAnswerById(answer.getId());
        questionRepository.save(question);
        answerRepository.deleteById(id);
    }
}
