package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.EntireDealAmount;
import com.ssafy.Whereismyhouse.house.model.dto.HouseDeal;


public interface HouseDealService {
	List<HouseDeal> searchAll() ;
	void insert(HouseDeal houseDeal) ;
	void update(HouseDeal houseDeal) ;
	List<HouseDeal> search(String aptCode) ;
	void    remove(String aptCode) ;
	List<EntireDealAmount>  entireDealAmount();
}
