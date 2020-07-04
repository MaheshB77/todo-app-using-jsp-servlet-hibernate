<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your TODOs</title>
<%@include file="components/common.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container mt-5">

		<c:if test="${user.todos.isEmpty()==false}">
			<div class="row">
				<div class="col-md-8 offset-md-2">
					<table class="table table-dark table-bordered text-center">
						<thead class="thead-dark">
							<tr>
								<th scope="col">TODO Name</th>
								<th scope="col">Target Date</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${user.todos }" var="todo">
								<tr>
									<td>${todo.todoName }</td>
									<td>${todo.todoTargetDate }</td>
									
<!-- 									Edit or Delete TODO -->
									<td><a
										href="TODOAction?action=edit&todoId=${todo.getTodoId()}">
											<button type="button" class="btn btn-primary">Edit</button>
									</a> <a href="TODOAction?action=delete&todoId=${todo.getTodoId()}">
											<button type="button" class="btn btn-danger">Delete</button>
									</a></td>
								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>
			</div>
		</c:if>
		<div class="row">

			<div class="col-md-4 offset-md-4 text-center">
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#addTodo">Add new TODO</button>

			</div>
		</div>

		<%@include file="components/addtodo.jsp"%>
	</div>

</body>
</html>