package com.ssafy.Whereismyhouse.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.Whereismyhouse.user.model.dto.Bookmark;



public interface BookmarkService {

	void insert(String id, String code) ;
	void insert(String id, String sido, String gugun, String dong) ;
	void delete(String id, String code);
	List<Bookmark> searchAll(String id) ;
}
