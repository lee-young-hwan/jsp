package com.example.libs.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class MemberDao {
	public static int register(MemberVO member) throws SQLException {
		Connection conn = DBConnection.getConnection();		// 2, 3
		String sql = "{ call sp_member_insert(?,?,?,?,?,?,?) }";
		CallableStatement cstmt = conn.prepareCall(sql);	// 4
		cstmt.setString(1, member.getUserid());
		cstmt.setString(2, member.getPasswd());
		cstmt.setString(3, member.getName());
		cstmt.setString(4, member.getEmail());
		cstmt.setString(5, member.getGender());
		cstmt.setString(6, member.getCity());
		cstmt.setInt(7, member.getAge()); // 여기까지가 완전한 SQL문장
		
		int row = cstmt.executeUpdate(); // 5 반응한 row의 개수
		DBClose.close(conn, cstmt); // 6
		return row;
	}
	
	// -1 : 존재하지 않는 아이디이다 , 	0 : 아이디는 있으나 비밀번호가 일치하지 않는다, 		1: 모두 일치한다
	public static int login(String userid, String passwd) throws SQLException{
		Connection conn = DBConnection.getConnection(); // 2, 3
		String sql = "{ call sp_member_login(?, ?)";
		CallableStatement cstmt = conn.prepareCall(sql); 	// 4
		cstmt.setString(1, userid);  // 들어올 때 setString
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); // 나갈 때 registerOutParameter
		cstmt.execute(); 	// 매우 주의하자
		
		Object obj = cstmt.getObject(2);
		ResultSet rs = (ResultSet)obj;
		
		int key = -2;
		
		if(rs.next()) {	// 아이디에 맞는 비밀번호를 가져왔다면
			String db_passwd = rs.getString("passwd");
			if(db_passwd.trim().equals(passwd.trim())) {
				key = 1;	// 모두 일치
			} else {
				key = 0;	// 비밀번호 불일치
			}
		} else {	// 아예 그런 아이디가 없다면
			key = -1;
		}
			
		DBClose.close(conn, cstmt); // 7
		return key;
	}
}
