package com.ssafy.Whereismyhouse.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Whereismyhouse.house.model.dto.Pollution;


public interface PollutionService {
	List<Pollution> searchByDong(int dongCode, String dongName);
}
