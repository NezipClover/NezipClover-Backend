package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.PollutionDao;
import com.ssafy.Whereismyhouse.house.model.dto.Pollution;


@Service
public class PollutionServiceImpl implements PollutionService {
	@Autowired
	private PollutionDao  dao ;
	
	@Override
	public List<Pollution> searchByDong(int dongCode,String dongName)  {
		return dao.searchByDong(dongCode, dongName);
	}

}
