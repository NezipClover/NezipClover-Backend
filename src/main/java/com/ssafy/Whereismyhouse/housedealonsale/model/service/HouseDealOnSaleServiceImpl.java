package com.ssafy.Whereismyhouse.housedealonsale.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.housedealonsale.model.dao.HouseDealOnSaleDao;
import com.ssafy.Whereismyhouse.housedealonsale.model.dto.HouseDealOnSale;

@Service
public class HouseDealOnSaleServiceImpl implements HouseDealOnSaleService {
	
	@Autowired
	private HouseDealOnSaleDao dao;
	
	@Override
	public List<HouseDealOnSale> searchAll() {
		
		return dao.searchAll();
	}

	@Override
	public void insert(HouseDealOnSale houseDealonSale) {
		dao.insert(houseDealonSale);

	}

	@Override
	public void update(HouseDealOnSale houseDealonSale) {
		dao.update(houseDealonSale);
	}

	@Override
	public void remove(int no) {
		dao.remove(no);

	}

	@Override
	public List<HouseDealOnSale> searchBydealerEmail(String dealerEmail) {
		return dao.searchBydealerEmail(dealerEmail);
	}

	@Override
	public List<HouseDealOnSale> searchByaptCode(int aptCode) {
		return dao.searchByaptCode(aptCode);
	}

}
