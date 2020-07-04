package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TODODao;
import models.TODO;
import models.Users;

public class TODOAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TODOAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		int todoId = Integer.parseInt(request.getParameter("todoId"));

		TODO todo = TODODao.getTODOById(todoId);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("editTodo", todo);
		if(action.equalsIgnoreCase("edit"))
		{
			response.sendRedirect("edittodo.jsp");
		}
		else
		{

//			Manually updating "User", because "User" inside httpSession was not updating after 
//			updating perticular "TODO"
			TODODao.deleteTodoById(todoId);
			Users user=(Users)httpSession.getAttribute("user");
			List<TODO> todos= TODODao.getAllTodos(user.getUserId());
			user.setTodos(todos);
			
			httpSession.setAttribute("user", user);
			response.sendRedirect("showtodos.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
