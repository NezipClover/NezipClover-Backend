package com.ssafy.Whereismyhouse.house.model.service;

import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.SidoGugunCodeDto;

public interface HouseMapService {

	List<SidoGugunCodeDto> getSido() ;
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<SidoGugunCodeDto> getdongInGugun(String gugun);
	
}
