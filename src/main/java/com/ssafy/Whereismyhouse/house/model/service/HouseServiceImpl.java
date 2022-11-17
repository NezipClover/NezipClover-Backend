package com.ssafy.Whereismyhouse.house.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.house.model.dao.HouseDao;
import com.ssafy.Whereismyhouse.house.model.dto.House;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseDao  dao;
	@Override
	public List<House> searchAll()  {
		return dao.searchAll();
	}

	@Override
	public void insert(House house)  {
		dao.insert(house);
	}

	@Override
	public void update(House House)  {
		dao.update(House);

	}

	@Override
	public House searchByApt(String aptCode)  {
		return dao.searchByApt(aptCode);
	}

	@Override
	public void remove(String aptCode)  {
		dao.remove(aptCode);
	}
	
	@Override
	public List<House> searchByDong(String dongCode)  {
		return dao.searchByDong(dongCode);
	}
//	public static void main(String[] args) throws SQLException {
//		List<House> houses = dao.searchByDong("평창동");
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(houses));
//	}
}
