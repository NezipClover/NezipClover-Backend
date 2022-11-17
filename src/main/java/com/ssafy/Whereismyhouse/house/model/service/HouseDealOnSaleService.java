package com.ssafy.Whereismyhouse.house.model.service;

import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.HouseDealOnSale;


public interface HouseDealOnSaleService {
	List<HouseDealOnSale> searchAll() ;
	void insert(HouseDealOnSale houseDealonSale) ;
	void update(HouseDealOnSale houseDealonSale) ;
	List<HouseDealOnSale> searchBydealerEmail(String dealerEmail) ;
	List<HouseDealOnSale> searchByaptCode(int aptCode);
	void remove(int no) ;
}
