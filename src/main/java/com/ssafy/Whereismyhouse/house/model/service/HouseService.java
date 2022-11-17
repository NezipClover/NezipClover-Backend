package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.House;

public interface HouseService {
	List<House> searchAll() ;
	void insert(House House) ;
	void update(House House);
	House searchByApt(String aptCode); 
	List<House> searchByDong(String dongCode);
	void    remove(String aptCode) ;
}
