package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.House;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;

public interface HouseService {
	List<House> searchAll(PageBean pageBean) ;
	void insert(House House) ;
	void update(House House);
	House searchByApt(String aptCode); 
	List<House> searchByDong(String dongCode);
	void    remove(String aptCode) ;
	Integer getAptCode();
}
