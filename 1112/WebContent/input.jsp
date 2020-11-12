<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
<jsp:useBean id="telephone" class="com.example.libs.model.TelephoneVO" />
<jsp:setProperty property="*" name="telephone"/>

<jsp:useBean id="insert" class="com.example.libs.service.InsertService" />
<%
	int row = insert.insertTelephone(telephone);
	if(row == 1)
		response.sendRedirect("list.jsp");
	else{
%>
	<script>
		alert("입력 실패");
		history.back();
	</script>
<%  }  %>