package com.ssafy.Whereismyhouse.housedealonsale.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.housedealonsale.model.dto.HouseDealOnSale;


@Mapper
public interface HouseDealOnSaleDao {
	List<HouseDealOnSale> searchAll() ;
	void insert(HouseDealOnSale houseDealonSale) ;
	void update(HouseDealOnSale houseDealonSale) ;
	List<HouseDealOnSale> searchBydealerEmail(String dealerEmail) ;
	List<HouseDealOnSale> searchByaptCode(int aptCode);
	void remove(int no) ;
	List<HouseDealOnSale> searchBydong(String dong);
}
