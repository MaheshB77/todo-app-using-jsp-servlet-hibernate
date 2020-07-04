package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.TODO;
import models.Users;

public class Helper {
	
	public static SessionFactory sf;
	public static SessionFactory getSessionFactory()
	{
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(Users.class);
		con.addAnnotatedClass(TODO.class);

		if(sf==null)
		{
			sf=con.buildSessionFactory();
			return sf;
		}
		else
		{
			return sf;
		}
	}

}
