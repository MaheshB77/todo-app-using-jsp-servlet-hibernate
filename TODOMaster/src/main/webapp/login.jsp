<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Login Page</title>
<%@include file="components/common.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container-fluid mt-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 30rem;">
					<div class="card-header text-center">Login Here</div>
					<div class="card-body">
						<form action="Login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="userEmail">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" name="userPassword">
							</div>
							
							<div class="container">
								<div class="row">
									<div class="col-md-12 text-center">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="reset" class="btn btn-secondary">Reset</button>
									</div>
								</div>
								
							</div>
							<c:if test="${sessionScope.message != null }">
								<div
									class="mt-2 alert alert-warning alert-dismissible fade show"
									role="alert" style="font-size: 15px">
									${sessionScope.message }
									<%
										session.removeAttribute("message");
									%>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:if>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>