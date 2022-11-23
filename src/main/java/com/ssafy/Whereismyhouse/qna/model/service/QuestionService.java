package com.ssafy.Whereismyhouse.qna.model.service;

import java.util.List;

import com.ssafy.Whereismyhouse.qna.model.dto.Question;
import com.ssafy.Whereismyhouse.qna.model.dto.QuestionRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;

public interface QuestionService {
	public List<Question>  searchAll();
	public List<Question>  searchAllByWord(String searchKey, String word);
	public Question  search(int id);
	public void insert(QuestionRegister questionRegister);
	public void update(Question question);
	public void delete(int id);
}
