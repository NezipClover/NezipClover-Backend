package com.ssafy.Whereismyhouse.qna.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.qna.model.dto.Answer;
import com.ssafy.Whereismyhouse.qna.model.dto.AnswerRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;

@Mapper
public interface AnswerDao {
	public List<Answer>  searchAll(int questionId, PageBean bean);
	public int totalCount(PageBean bean);
	public Answer  search(int id);
	public void insert(AnswerRegister answerRegister);
	public void update(Answer answer);
	public void delete(int id);
}
	