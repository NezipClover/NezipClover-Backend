package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.DongCodeDao;

@Service																		
public class DongCodeServiceImpl implements DongCodeService {
	@Autowired
	private DongCodeDao dao;


	
	@Override
	public String getDongCode(String sido, String gugun, String dong)  {

		return dao.getDongCode(sido, gugun, dong);
	}

}
