package com.ssafy.Whereismyhouse.house.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.house.model.dto.SidoGugunCodeDto;


@Mapper
public interface HouseMapDao {

	List<SidoGugunCodeDto> getSido() ;
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<SidoGugunCodeDto> getdongInGugun(String guGun);
	
}
