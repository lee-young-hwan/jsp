<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:requestEncoding value="utf-8" />
<jsp:useBean id="member" class="com.example.libs.model.MemberVO" />  <!-- 기본생성자를 생성한다는 뜻 -->
<jsp:setProperty property="*" name="member" />

<jsp:useBean id="insert" class="com.example.libs.service.InsertService" /> <!-- 기본생성자를 생성한다는 뜻 -->
<c:set var="row" value="<%=insert.insertMember(member) %>"/>
<c:if test="${row eq 1}">
	<c:set var="userid" value="${member.userid}" scope="session" /> <!-- 회원가입할때 id가 로그인할때 id로 찍힌다 -->
	<script>
		alert("회원가입 성공");
		location.href = "login.jsp";  	// 회원가입 성공했으면 login.jsp로 넘어간다
	</script>
</c:if>

<c:if test="${row ne 1}">  <!-- 회원가입에 실패했다면 -->
	<script>
		alert("회원가입 실패");
		history.back();  	// 회원가입 실패했다면 뒤로 돌아간다
	</script>
</c:if>