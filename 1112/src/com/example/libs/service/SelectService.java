package com.example.libs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.model.TelephoneDao;
import com.example.libs.model.TelephoneVO;

public class SelectService {
	public ArrayList<TelephoneVO> selectTelephone(){
		ArrayList<TelephoneVO> list = null;
		try {
			list = TelephoneDao.select();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public String getCurrentDate() {
		String date = null;
		try {
			date = TelephoneDao.getCurrentDate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}




