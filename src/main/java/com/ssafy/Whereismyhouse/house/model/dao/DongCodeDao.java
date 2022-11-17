package com.ssafy.Whereismyhouse.house.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DongCodeDao {
	String getDongCode(String sido, String gugun, String dong );
}
