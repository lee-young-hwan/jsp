<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import="com.example.libs.model.*" %>
<%@ page import="java.sql.*" %>
<%
	Connection conn = DBConnection.getConnection();
	out.println(conn);
	DBClose.close(conn);
%>