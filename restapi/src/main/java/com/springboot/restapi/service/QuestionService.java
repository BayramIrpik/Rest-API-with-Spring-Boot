package com.springboot.restapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.entity.Question;
import com.springboot.restapi.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	 public List<Question> listAllQuestion() {
	        return questionRepository.findAll();
	    }

	    public void saveQuestion(Question question) {
	    	questionRepository.save(question);
	    }

	    public Question getQuestion(Long id) {
	        return questionRepository.findById(id).get();
	    }

	    public void deleteQuestion(Long id) {
	    	questionRepository.deleteById(id);
	    }
}
