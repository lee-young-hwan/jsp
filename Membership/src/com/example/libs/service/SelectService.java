package com.example.libs.service;

import java.sql.SQLException;

import com.example.libs.model.MemberDao;

public class SelectService {
	public int loginMember(String userid, String passwd) {
		int key = 02;
		try {
			key = MemberDao.login(userid, passwd);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return key;
	}
}
