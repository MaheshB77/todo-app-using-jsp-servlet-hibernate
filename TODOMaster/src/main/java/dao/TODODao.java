package dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.TODO;
import models.Users;
import utils.Helper;

public class TODODao {

	public static void addNewTODO(int userId,String todoName,Date todoTargetDate)
	{
		SessionFactory sessionFactory = Helper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Users user=session.get(Users.class, userId);
		TODO newTodo=new TODO(todoName, todoTargetDate);
		List<TODO> todos=user.getTodos();
		todos.add(newTodo);
		
		transaction.commit();
		session.close();
	}
	
	public static TODO getTODOById(int todoId)
	{
		SessionFactory sessionFactory = Helper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from TODO where todoId=:todoId");
		query.setParameter("todoId", todoId);
		
		TODO todo=(TODO)query.uniqueResult();
		
		transaction.commit();
		session.close();
		
		return todo;
	}
	public static void editTODO(int todoId,String todoName,Date todoTargetDate)
	{
		SessionFactory sessionFactory = Helper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String q="update TODO set todoName=:todoName,todoTargetDate=:todoTargetDate "
				+ "where todoId=:todoId";
		Query query=session.createQuery(q);
		query.setParameter("todoName", todoName);
		query.setParameter("todoTargetDate", todoTargetDate);
		query.setParameter("todoId", todoId);
		
		query.executeUpdate();
		
		transaction.commit();
		session.close();
	}
	
	public static List<TODO> getAllTodos(int userId)
	{
		SessionFactory sessionFactory = Helper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from TODO where userId=:userId");
		query.setParameter("userId", userId);
		List<TODO> todos=query.list();
		
		transaction.commit();
		session.close();
		return todos;
	}
	
	public static void deleteTodoById(int todoId)
	{
		SessionFactory sessionFactory = Helper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("delete from TODO where todoId=:todoId");
		query.setParameter("todoId", todoId);
		query.executeUpdate();

		transaction.commit();
		session.close();
	}
}