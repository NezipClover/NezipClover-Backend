package com.ssafy.Whereismyhouse.user.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.user.model.dao.BookmarkDao;
import com.ssafy.Whereismyhouse.user.model.dto.Bookmark;


@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkDao bookmarkDao;
	

	
	@Override
	public void insert(String id, String code)  {
		bookmarkDao.insert(id, code);
	}

	@Override
	public void delete(String id, String code) {
		bookmarkDao.delete(id, code);
	}

	@Override
	public List<Bookmark> searchAll(String id)  {
		return bookmarkDao.searchAll(id);
	}

	@Override
	public void insert(String id, String sido, String gugun, String dong)  {
		bookmarkDao.insert(id, sido, gugun, dong);
	}

}
