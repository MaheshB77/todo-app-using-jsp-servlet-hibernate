<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="components/common.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="banner">
		<div class="container h-100">

			<div class="row align-items-center h-100">
				<div class="col-md-12 text-center">
					<h2>Welcome To TODO Master</h2>
					<p>If you want to do more productive work by managing your
						tasks then you have come to right place.</p>
					<c:if test="${user!=null}">
						<a href="showtodos.jsp">
							<button class="btn btn-primary">See your TODO list</button>
						</a>
					</c:if>
				</div>
			</div>
		</div>

	</div>

</body>
</html>