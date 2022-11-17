package com.ssafy.Whereismyhouse.qna.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
import com.ssafy.Whereismyhouse.qna.model.dto.Question;
import com.ssafy.Whereismyhouse.qna.model.dto.QuestionRegister;

@Mapper
public interface QuestionDao {
	public List<Question>  searchAll(PageBean bean);
	public int totalCount(PageBean bean);
	public Question  search(int id);
	public void insert(QuestionRegister questionRegister);
	public void update(Question question);
	public void delete(int id);
}
	