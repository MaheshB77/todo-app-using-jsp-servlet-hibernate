package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Users;
import utils.Helper;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean validation=false;
		HttpSession httpSession=request.getSession();
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");
		String userBirthDate=request.getParameter("userBirthDate");
		String userPassword=request.getParameter("userPassword");
		String userPassword2=request.getParameter("userPassword2");
		

//		Confirm Password
		if(!userPassword.equals(userPassword2))
		{
			httpSession.setAttribute("message", "Both Passwords does not matched!!");
			response.sendRedirect("signup.jsp");
			return;
		}
		
//		Validation of user
		validation=doValidation(userEmail, userPassword);
		
		if(validation==false)
		{
			httpSession.setAttribute("message", "Email or Password already exists");
			response.sendRedirect("signup.jsp");
		}
		
		else {
			
//			Regestration of user
			SessionFactory sf=Helper.getSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			
			Users user=new Users(userName, userEmail, Date.valueOf(userBirthDate), userPassword);
			
			session.save(user);
			
			tx.commit();
			session.close();
			
			httpSession.setAttribute("user", user);
			response.sendRedirect("showtodos.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean doValidation(String userEmail,String userPassword)
	{
		boolean result=false;
		String query1="from Users where userEmail=:userEmail";
		String query2="from Users where userPassword=:userPassword";
		
		SessionFactory sf=Helper.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Query q1=session.createQuery(query1);
		Query q2=session.createQuery(query2);
		
		q1.setParameter("userEmail", userEmail);
		q2.setParameter("userPassword", userPassword);
		
		Users u1=(Users)q1.uniqueResult();
		Users u2=(Users)q2.uniqueResult();
		
		if(u1==null&&u2==null)
		{
			result=true;
		}
		else
		{
			result=false;
		}
		
		tx.commit();
		session.close();
		return result;
	}
}
