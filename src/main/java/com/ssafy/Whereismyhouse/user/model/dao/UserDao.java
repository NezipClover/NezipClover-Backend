package com.ssafy.Whereismyhouse.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.Whereismyhouse.user.model.dto.User;


@Mapper
public interface UserDao {	
	
	int emailCheck(String email) ;		//이메일 중복 검사
	void join(User user) ;			//회원가입
	User login(String email, String password) ;	//로그인	
	void update(User user) ;			//회원정보 수정
	int delete(String email, String password) ;	//회원탈퇴
}
