package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TODODao;
import models.TODO;
import models.Users;

/**
 * Servlet implementation class TODOEdit
 */
public class TODOEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TODOEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		TODO todo=(TODO)httpSession.getAttribute("editTodo");
		String todoName=request.getParameter("todoName");
		Date todoTargetDate=Date.valueOf(request.getParameter("todoTargetDate"));
		TODODao.editTODO(todo.getTodoId(), todoName, todoTargetDate);


//		Manually updating "User", because "User" inside httpSession was not updating after 
//		updating perticular "TODO"
		Users user=(Users)httpSession.getAttribute("user");
		List<TODO> updatedTodos=TODODao.getAllTodos(user.getUserId());
		user.setTodos(updatedTodos);
		
		httpSession.setAttribute("user", user);
		httpSession.removeAttribute("editTodo");
		response.sendRedirect("showtodos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
