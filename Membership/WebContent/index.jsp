<%@ page  contentType="text/html; charset=utf-8" 
		pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap ì¬ì© ìí´-->
<link rel = "stylesheet"  href = "css/bootstrap.css">
<script src = "js/jquery-3.5.1.js"></script>
<script>
	$(document).ready(function(){
		$('#btnRegister').on('click', function(){
			location.href = "register.html";
		});
		$('#btnLogin').on('click', function(){
			location.href = "login.jsp";
		});
	});
</script>

</head>
<body>

    <!-- 반응형 웹을 위해 container>row  -->
    <div class="container">
        <div class="row">
            <!-- bootstrap의 jumbotron사용-->
            <div class="jumbotron">
            
            <c:if test="${empty sessionScope.userid}">
            	<h1>Welcome to example.com</h1>
            </c:if>
            
            <c:if test="${not empty sessionScope.userid}">
            	<h1>Welcome to <c:out value="${sessionScope.userid}" />님!</h1>
            </c:if>
            <p>
               Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis quis quo inventore error et magni aut pariatur sapiente earum minima expedita, sed rem facere dolores in, numquam harum, qui cupiditate!
              Voluptate accusamus iure assumenda nostrum porro? Corrupti, nihil? Iste adipisci officia saepe magnam facilis? Aliquid odit sequi natus modi veniam. Debitis mollitia quibusdam praesentium nam veniam quam, exercitationem numquam vitae!
              Possimus consequatur totam illum vero magni cum, quo nam exercitationem optio ratione nulla unde, pariatur dolore culpa a facere omnis aliquam dignissimos placeat atque corrupti iusto aspernatur! Voluptate, temporibus aspernatur.
              Consequuntur nostrum provident eius debitis recusandae vitae inventore consectetur, adipisci aspernatur mollitia ullam distinctio et blanditiis labore iusto enim nam voluptatibus, omnis dolorem necessitatibus amet architecto. Harum facere quo aperiam.
              Aperiam veniam laboriosam dignissimos, quibusdam inventore ipsam doloremque id, distinctio eveniet aliquam ab porro labore esse est ea ipsum modi hic error harum nesciunt ratione, quo fugiat. Dolorum, in tenetur.
            </p>
            
             <p>
             	<button id="btnRegister" class="btn btn-warning btn-lg">회원가입</button>
             	
             	<c:if test="${empty sessionScope.userid}">
             	<button id="btnLogin" class="btn btn-info btn-lg">Log In</button>
             	</c:if>
             	
             	<c:if test="${not empty sessionScope.userid}">
             	<button id="btnLogout" class="btn btn-warning btn-lg">Log Out</button>
             	</c:if>
             </p>               
            </div>
        </div>
    </div>

    

</body>
</html>