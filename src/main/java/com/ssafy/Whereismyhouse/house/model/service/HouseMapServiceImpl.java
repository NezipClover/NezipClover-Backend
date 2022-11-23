package com.ssafy.Whereismyhouse.house.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.HouseMapDao;
import com.ssafy.Whereismyhouse.house.model.dto.SidoGugunCodeDto;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	private HouseMapDao dao;
	@Override
	public List<SidoGugunCodeDto> getSido()  {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido)  {
		return dao.getGugunInSido(sido);
	}

	
	@Override
	public List<SidoGugunCodeDto> getdongInGugun(String guGun) {
		return dao.getdongInGugun(guGun);
	}

}
