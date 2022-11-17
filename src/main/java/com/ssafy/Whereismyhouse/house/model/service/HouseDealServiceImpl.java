package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.HouseDealDao;
import com.ssafy.Whereismyhouse.house.model.dto.HouseDeal;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	@Autowired
	private HouseDealDao  dao;
	
	@Override
	public List<HouseDeal> searchAll()  {
		
		return dao.searchAll();
	}

	@Override
	public void insert(HouseDeal houseDeal)  {
		dao.insert(houseDeal);

	}

	@Override
	public void update(HouseDeal houseDeal)  {
		dao.update(houseDeal);
	}

	@Override
	public List<HouseDeal> search(String aptCode) {
		return dao.search(aptCode);
	}

	@Override
	public void remove(String aptCode)  {
		dao.remove(aptCode);

	}

}
