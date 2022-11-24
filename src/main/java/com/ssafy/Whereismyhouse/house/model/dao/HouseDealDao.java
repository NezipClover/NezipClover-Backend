package com.ssafy.Whereismyhouse.house.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.house.model.dto.EntireDealAmount;
import com.ssafy.Whereismyhouse.house.model.dto.HouseDeal;
@Mapper
public interface HouseDealDao {
	List<HouseDeal> searchAll() ;
	void insert(HouseDeal houseDeal) ;
	void update(HouseDeal houseDeal) ;
	List<HouseDeal> search(String aptCode) ;
	void    remove(String aptCode) ;
	
	List<EntireDealAmount> EntireDealAmount();
}
