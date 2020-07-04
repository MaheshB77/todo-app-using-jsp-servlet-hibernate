package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Users;
import utils.Helper;

public class UserDao {

	public static boolean validateUser(String userEmail,String userPassword)
	{
		String q="from Users where userEmail=:userEmail and userPassword=:userPassword";
		boolean status=false;
		SessionFactory sf=Helper.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		Query query=session.createQuery(q);
		query.setParameter("userEmail", userEmail);
		query.setParameter("userPassword", userPassword);

		Users u=(Users)query.uniqueResult();
		if(u==null)
		{
			status=false;
		}
		else
		{
			status=true;
		}

		tx.commit();
		session.close();
		return status;
	}

	public static Users getUser(String userEmail)
	{
		SessionFactory sf=Helper.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		Query query=session.createQuery("from Users where userEmail=:userEmail");
		query.setParameter("userEmail", userEmail);

		Users user=(Users)query.uniqueResult();

		tx.commit();
		session.close();
		return user;
	}
	public static Users getUserById(int userId)
	{	
		SessionFactory sf=Helper.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		Query query=session.createQuery("from Users where userId=:userId");
		query.setParameter("userId", userId);

		Users user=(Users)query.uniqueResult();

		tx.commit();
		session.close();
		return user;


	}
}
