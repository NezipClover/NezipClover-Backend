package com.ssafy.Whereismyhouse.housedealonsale.model.service;

import java.util.List;

import com.ssafy.Whereismyhouse.housedealonsale.model.dto.HouseDealOnSale;


public interface HouseDealOnSaleService {
	List<HouseDealOnSale> searchAll() ;
	void insert(HouseDealOnSale houseDealonSale) ;
	void update(HouseDealOnSale houseDealonSale) ;
	List<HouseDealOnSale> searchBydealerEmail(String dealerEmail) ;
	List<HouseDealOnSale> searchByaptCode(int aptCode);
	void remove(int no) ;
	List<HouseDealOnSale> searchBydong(String dong);
}
