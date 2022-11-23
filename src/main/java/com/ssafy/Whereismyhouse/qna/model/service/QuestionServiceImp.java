package com.ssafy.Whereismyhouse.qna.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.Whereismyhouse.qna.model.dao.QuestionDao;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
import com.ssafy.Whereismyhouse.qna.model.dto.Question;
import com.ssafy.Whereismyhouse.qna.model.dto.QuestionRegister;

import com.ssafy.util.PageUtility;

@Service
public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	private QuestionDao dao;

	@Override
	//@Transactional(readOnly = true)
	public List<Question> searchAll() {
		return dao.searchAll();
	}
	

	@Override
	//@Transactional(readOnly = true)
	public List<Question> searchAllByWord(String searchKey, String word) {
		return dao.searchAllByWord(searchKey, word);
	}

	@Override
	public Question search(int id) {
		// TODO Auto-generated method stub
		return dao.search(id);
	}

	@Override
	public void insert(QuestionRegister questionRegister) {
		dao.insert(questionRegister);
		
	}

	@Override
	public void update(Question question) {
		dao.update(question);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}
		
}
