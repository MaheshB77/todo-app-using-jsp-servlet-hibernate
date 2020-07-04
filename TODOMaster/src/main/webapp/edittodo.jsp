<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit TODO</title>

<%@include file="components/common.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">

				<form action="TODOEdit" method="post">
					<div class="form-group">
						<label for="todoName">TODO Description</label> <input type="text"
							class="form-control" id="todoName" name="todoName" required>
					</div>
					<div class="form-group">
						<label for="todoTargetDate">Set target date for this todo
						</label> <input type="date" class="form-control" id="todoTargetDate"
							name="todoTargetDate" required>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-success">Edit TODO</button>
					</div>
				</form>

			</div>
		</div>
	</div>

</body>
</html>