package com.ssafy.Whereismyhouse.house.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.DongCodeDao;
import com.ssafy.Whereismyhouse.house.model.dto.DongCode;

@Service																		
public class DongCodeServiceImpl implements DongCodeService {
	@Autowired
	private DongCodeDao dao;


	
	@Override
	public DongCode getDongCode(String dongName)  {

		return dao.getDongCode(dongName);
	}

}
