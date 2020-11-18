<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="member" class="com.example.libs.model.MemberVO" />
<jsp:setProperty name="member" property="userid" param="userid" />
<jsp:setProperty name="member" property="passwd" param="passwd" />

<jsp:useBean id="select" class="com.example.libs.service.SelectService" />
<c:set var="key" 
		value="<%=select.loginMember(member.getUserid(), member.getPasswd()) %>" />
		
<c:if test="${key eq -1}">
<script>
	alert("존재하지 않는 아이디입니다. \n확인후 다시 로그인 해 주세요.");
	history.back();
</script>
</c:if>

<c:if test="${key eq 0}">
<script>
	alert("비밀번호가 일치하지 않습니다.. \n확인후 다시 로그인 해 주세요.");
	history.back();
</script>
</c:if>

<c:if test="${key eq 1}">
	<c:set var="userid" value="${member.userid}" scope="session" />
	<script>
		location.href = "/membership/";
	</script>
</c:if>

	
