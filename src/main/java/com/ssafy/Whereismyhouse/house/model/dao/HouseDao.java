package com.ssafy.Whereismyhouse.house.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.house.model.dto.House;

@Mapper
public interface HouseDao {
	List<House> searchAll() ;
	void insert(House House) ;
	void update(House House) ;
	House searchByApt(String aptCode) ;
	List<House> searchByDong(String dongCode) ;
	void    remove(String aptCode) ;
}
