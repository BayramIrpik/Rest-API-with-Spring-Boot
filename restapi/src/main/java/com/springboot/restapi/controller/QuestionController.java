package com.springboot.restapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.entity.Question;
import com.springboot.restapi.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("")
	public List<Question> list() {
        return questionService.listAllQuestion();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Question> get(@PathVariable Long id) {
        try {
        	Question question = questionService.getQuestion(id);
            return new ResponseEntity<Question>(question, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping("")
    public void add(@RequestBody Question question) {
		questionService.saveQuestion(question);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Question question, @PathVariable Long id) {
        try {
        	Question existQuestion = questionService.getQuestion(id);
        	question.setId(id);            
        	questionService.saveQuestion(question);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

		questionService.deleteQuestion(id);
    }
}
