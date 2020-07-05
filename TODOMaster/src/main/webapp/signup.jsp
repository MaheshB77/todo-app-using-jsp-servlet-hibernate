<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create your account</title>
<%@include file="components/common.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container-fluid mt-3" style="font-size: 20px">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card text-white bg-dark mb-3" style="max-width: 30rem;">
					<div class="card-header text-center">Sign-Up</div>
					<div class="card-body">
						<form action="SignUp" method="post">


							<div class="form-group">
								<label for="userName">Enter Your Name</label> <input type="text"
									class="form-control" id="userName" name="userName" required>
							</div>

							<div class="form-group">
								<label for="userEmail">Email address</label> <input type="email"
									class="form-control" id="userEmail" name="userEmail"
									aria-describedby="emailHelp" required>
							</div>

							<div class="form-group">
								<label for="userBirthDate">Select Your Birth-Date</label> <input
									type="date" class="form-control" id="userBirthDate"
									name="userBirthDate" required>
							</div>
							<div class="form-group">
								<label for="userPassword">Password</label> <input
									type="password" class="form-control" id="userPassword"
									name="userPassword" required>
							</div>
							<div class="form-group">
								<label for="userPassword2">Confirm Password</label> <input
									type="password" class="form-control" id="userPassword2"
									name="userPassword2" required>
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

									<c:remove var="message" scope="session" />
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