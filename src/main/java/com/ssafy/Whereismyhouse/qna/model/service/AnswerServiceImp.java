package com.ssafy.Whereismyhouse.qna.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.Whereismyhouse.qna.model.dao.AnswerDao;
import com.ssafy.Whereismyhouse.qna.model.dao.QuestionDao;
import com.ssafy.Whereismyhouse.qna.model.dto.Question;
import com.ssafy.Whereismyhouse.qna.model.dto.QuestionRegister;
import com.ssafy.util.PageUtility;
import com.ssafy.Whereismyhouse.qna.model.dto.Answer;
import com.ssafy.Whereismyhouse.qna.model.dto.AnswerRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;

@Service
public class AnswerServiceImp implements AnswerService {

	@Autowired
	private AnswerDao dao;
	
	@Override
	public List<Answer> searchAll(int questionId, PageBean bean) {
		// TODO Auto-generated method stub
		System.out.println("answer......!");
		return dao.searchAll(questionId, bean);
	}
	
	
	
	
	
//
//	@Override
//	public Answer search(int id) {
//		// TODO Auto-generated method stub
//		return dao.search(id);
//	}

	@Override
	public void insert(AnswerRegister answerRegister) {
		dao.insert(answerRegister);
		
	}

	@Override
	public void update(Answer answer) {
		dao.update(answer);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}
	

	
}
