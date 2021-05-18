package com.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Question;

public interface QuestionRepository  extends JpaRepository<Question,Long>{

}
