package com.ssafy.Whereismyhouse.house.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.house.model.dto.DongCode;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
@Mapper
public interface DongCodeDao {
	DongCode getDongCode(String dongName );
}
