package com.example.libs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TelephoneDao {
	public static ArrayList<TelephoneVO> select() throws SQLException{
		Connection conn = DBConnection.getConnection();   //2, 3
		Statement stmt = conn.createStatement();        //4
		String sql = "SELECT * FROM Telephone";
		ResultSet rs = stmt.executeQuery(sql);             //5
		ArrayList<TelephoneVO> list = new ArrayList<TelephoneVO>();
		if(rs.next()) {  //data가 있다면
			do {
				TelephoneVO telephone = new TelephoneVO(rs.getInt("kind"),
						rs.getString("tel"), rs.getString("name"), rs.getInt("quantity"),
						rs.getInt("defaultfee"), rs.getInt("fee"), rs.getInt("tax"),
						rs.getInt("total"));
				list.add(telephone);								
			}while(rs.next());
		}else {   //data가 없다면
			list = null;
		}
		DBClose.close(conn, stmt);   //6
		return list;
	}
	
	public static String getCurrentDate() throws SQLException{
		Connection conn = DBConnection.getConnection();   //2, 3
		Statement stmt = conn.createStatement();        //4
		String sql = "SELECT DATE_FORMAT(Now(), '%Y-%m-%d %T')";
		ResultSet rs = stmt.executeQuery(sql); 
		rs.next();
		String date = rs.getString(1);
		DBClose.close(conn, stmt);   //6
		return date;
	}
	
	public static int insert(TelephoneVO telephone) throws SQLException{
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO Telephone(kind, tel, name, quantity, defaultFee, fee, tax, total) " +
		                 " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, telephone.getKind());
		pstmt.setString(2, telephone.getTel());
		pstmt.setString(3, telephone.getName());
		pstmt.setInt(4, telephone.getQuantity());
		pstmt.setInt(5, telephone.getDefaultFee());
		pstmt.setInt(6, telephone.getFee());
		pstmt.setInt(7, telephone.getTax());
		pstmt.setInt(8, telephone.getTotal());
		int row = pstmt.executeUpdate();
		DBClose.close(conn, pstmt);
		return row;
	}
}







