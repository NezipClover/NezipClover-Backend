package com.ssafy.Whereismyhouse.qna.model.service;

import java.util.List;

import com.ssafy.Whereismyhouse.qna.model.dto.Answer;
import com.ssafy.Whereismyhouse.qna.model.dto.AnswerRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;

public interface AnswerService {

	public List<Answer>  searchAll(int questionId, PageBean bean);
	//public Answer  search(int id);
	public void insert(AnswerRegister answerRegister);
	public void update(Answer answer);
	public void delete(int id);
}
