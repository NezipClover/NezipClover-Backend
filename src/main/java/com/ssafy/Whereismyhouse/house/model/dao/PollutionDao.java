package com.ssafy.Whereismyhouse.house.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.house.model.dto.Pollution;
@Mapper
public interface PollutionDao {
	List<Pollution> searchByDong(int dongCode,String dongName);
}
