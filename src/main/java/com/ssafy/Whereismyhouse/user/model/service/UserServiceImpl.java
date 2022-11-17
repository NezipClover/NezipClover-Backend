package com.ssafy.Whereismyhouse.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.Whereismyhouse.user.model.dao.UserDao;
import com.ssafy.Whereismyhouse.user.model.dto.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	

	@Override
	public int emailCheck(String email)  {
		return userDao.emailCheck(email);
	}

	@Override
	public void join(User user)  {
		userDao.join(user);
	}

	@Override
	public User login(String email, String password)  {
		return userDao.login(email, password);
	}

	@Override
	public void update(User user)  {
		userDao.update(user);
	}

	@Override
	public int delete(String email, String password) {
		return userDao.delete(email, password);
	}

}
