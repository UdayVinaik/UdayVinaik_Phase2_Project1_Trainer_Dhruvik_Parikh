package com.programs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.programs.entity.Student;
import com.programs.entity.Subject;
import com.programs.entity.Teacher;
import com.programs.entity.Class;

public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Class.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
		return sessionFactory;
	}
}