package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.TODODao;
import dao.UserDao;
import models.TODO;
import models.Users;
import utils.Helper;

public class TODOController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public TODOController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String todoName = request.getParameter("todoName");
		Date todoTargetDate=Date.valueOf(request.getParameter("todoTargetDate"));
		
		HttpSession httpSession=request.getSession();
		Users user =(Users) httpSession.getAttribute("user");
		TODODao.addNewTODO(user.getUserId(), todoName, todoTargetDate);
		
		user=UserDao.getUserById(user.getUserId());
		httpSession.setAttribute("user", user);
		response.sendRedirect("showtodos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
