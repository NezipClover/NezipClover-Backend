package com.ssafy.Whereismyhouse.user.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.user.model.dto.Bookmark;


@Mapper
public interface BookmarkDao {

	void insert(String id, String code) ;
	void insert(String id, String sido, String gugun, String dong) ;
	void delete(String id, String code) ;
	List<Bookmark> searchAll(String id) ;
}
